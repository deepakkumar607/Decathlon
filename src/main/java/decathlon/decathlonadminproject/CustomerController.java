package decathlon.decathlonadminproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChangeRequestService changeRequestService;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/customer")
    public String showCustomerUpdatePage(Model model) {
        Customer customer = customerService.getCustomer();
        model.addAttribute("customer", customer);
        model.addAttribute("changeRequest", new ChangeRequest());
        return "customer-update";
    }

    @PostMapping("/submit")
    public String submitChangeRequest(@Validated @ModelAttribute("changeRequest") ChangeRequest changeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-update";
        }

        String emailOTP = OTPUtils.generateOTP();
        String phoneOTP = OTPUtils.generateOTP();

        // Validate email OTP
        boolean isEmailOTPValid = OTPUtils.validateEmailOTP(changeRequest.getEmailOTP(), emailOTP);

        // Validate phone OTP
        boolean isPhoneOTPValid = OTPUtils.validatePhoneOTP(changeRequest.getPhoneOTP(), phoneOTP);

        if (!isEmailOTPValid || !isPhoneOTPValid) {
            // Handle OTP validation failure
            return "customer-update";
        }

        changeRequest.setStatus("Pending");
        changeRequestService.createRequest(changeRequest);

        // Generate and send email notification to the user
        sendEmailNotification(changeRequest);

        return "redirect:/customer";
    }

    private void sendEmailNotification(ChangeRequest changeRequest) {
        String recipientEmail = changeRequest.getNewEmail();
        String subject = "Contact Details Update Request";
        String message = "Your contact details update request has been received and is pending admin approval.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientEmail);
        email.setSubject(subject);
        email.setText(message);
        javaMailSender.send(email);
    }
}
