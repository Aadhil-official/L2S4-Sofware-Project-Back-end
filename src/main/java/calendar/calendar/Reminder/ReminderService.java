package calendar.calendar.Reminder;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Scheduled(fixedRate = 60000) // Run every minute
    public void checkReminders() {
        List<Reminder> reminders = reminderRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        for (Reminder reminder : reminders) {
            LocalDateTime reminderTime = LocalDateTime.parse(reminder.getReminderTime(), DateTimeFormatter.ISO_DATE_TIME);
            if (reminderTime.isBefore(now) || reminderTime.isEqual(now)) {
                sendEmail(reminder);
                reminderRepository.delete(reminder);
            }
        }
    }

    private void sendEmail(Reminder reminder) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(reminder.getEmail());
        message.setSubject("Reminder: " + reminder.getTitle());
        message.setText("Event: " + reminder.getTitle() + "\nStart Time: " + reminder.getStartTime() + "\nEnd Time: " + reminder.getEndTime());
        javaMailSender.send(message);
    }
}
