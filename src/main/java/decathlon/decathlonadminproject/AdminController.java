package decathlon.decathlonadminproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private ChangeRequestService changeRequestService;

    @GetMapping("/admin/requests")
    public String showRequests(Model model) {
        List<ChangeRequest> changeRequests = changeRequestService.getAllRequests();
        model.addAttribute("changeRequests", changeRequests);
        return "admin-requests.html";
    }

    @PostMapping("/admin/requests/accept/{id}")
    public String acceptRequest(@PathVariable Long id, @RequestParam String reason) {
        ChangeRequest changeRequest = changeRequestService.getRequestById(id);
        if (changeRequest != null) {
            changeRequest.setStatus("Accepted");
            changeRequest.setReason(reason);
            // Call external API for updating the contact details
            // ...

            changeRequestService.updateRequest(changeRequest);
        }
        return "redirect:/admin/requests";
    }

    @PostMapping("/admin/requests/reject/{id}")
    public String rejectRequest(@PathVariable Long id, @RequestParam String reason) {
        ChangeRequest changeRequest = changeRequestService.getRequestById(id);
        if (changeRequest != null) {
            changeRequest.setStatus("Rejected");
            changeRequest.setReason(reason);
            // Send rejection email to the user
            // ...

            changeRequestService.updateRequest(changeRequest);
        }
        return "redirect:/admin/requests";
    }
}
