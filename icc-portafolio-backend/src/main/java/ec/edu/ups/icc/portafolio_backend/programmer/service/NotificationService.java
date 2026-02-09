package ec.edu.ups.icc.portafolio_backend.programmer.service;

import ec.edu.ups.icc.portafolio_backend.programmer.entity.Advisory;
import ec.edu.ups.icc.portafolio_backend.shared.util.MailTemplates;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notifyByEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception ex) {
            // en dev se ignora
        }
    }

    public void notifyAdvisoryCreated(Advisory advisory) {
        notifyByEmail(
            advisory.getRequesterEmail(),
            "Asesoría creada",
            MailTemplates.advisoryCreatedForRequester(advisory)
        );
        notifyByEmail(
            advisory.getProfile().getUser().getEmail(),
            "Nueva asesoría solicitada",
            MailTemplates.advisoryCreatedForProgrammer(advisory)
        );
    }

    public void notifyAdvisoryUpdated(Advisory advisory) {
        notifyByEmail(
            advisory.getRequesterEmail(),
            "Asesoría actualizada",
            MailTemplates.advisoryUpdatedForRequester(advisory)
        );
        notifyByEmail(
            advisory.getProfile().getUser().getEmail(),
            "Estado de asesoría actualizado",
            MailTemplates.advisoryUpdatedForProgrammer(advisory)
        );
    }

    public void notifyAdvisoryReminder(Advisory advisory) {
        notifyByEmail(
            advisory.getRequesterEmail(),
            "Recordatorio de asesoría",
            MailTemplates.advisoryReminderForRequester(advisory)
        );
        notifyByEmail(
            advisory.getProfile().getUser().getEmail(),
            "Recordatorio de asesoría",
            MailTemplates.advisoryReminderForProgrammer(advisory)
        );
    }
}