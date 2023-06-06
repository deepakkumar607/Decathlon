package decathlon.decathlonadminproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "decathlon", schema = "decathlon_schema")
public class ChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "old_email")
    private String oldEmail;

    @Column(name = "new_email")
    private String newEmail;

    @Column(name = "email_validated")
    private boolean emailValidated;

    @Column(name = "old_phone")
    private String oldPhone;

    @Column(name = "new_phone")
    private String newPhone;

    @Column(name = "phone_validated")
    private boolean phoneValidated;

    @Column(name = "email_otp")
    private String emailOTP;

    @Column(name = "phone_otp")
    private String phoneOTP;

    @Column(name = "reason")
    @Size(max = 250, message = "Reason should not exceed 250 characters")
    private String reason;

    @Column(name = "status")
    private String status;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public boolean isEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(boolean emailValidated) {
        this.emailValidated = emailValidated;
    }

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public boolean isPhoneValidated() {
        return phoneValidated;
    }

    public void setPhoneValidated(boolean phoneValidated) {
        this.phoneValidated = phoneValidated;
    }

    public String getEmailOTP() {
        return emailOTP;
    }

    public void setEmailOTP(String emailOTP) {
        this.emailOTP = emailOTP;
    }

    public String getPhoneOTP() {
        return phoneOTP;
    }

    public void setPhoneOTP(String phoneOTP) {
        this.phoneOTP = phoneOTP;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
