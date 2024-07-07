package calendar.calendar.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
// import java.time.format.TextStyle;
import java.util.List;
// import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    public Map<String, Long> getCurrentMonthStatus() {
        List<Jobs> jobs = jobsRepository.findAll();
        Month currentMonth = LocalDate.now().getMonth();

        return jobs.stream()
                .filter(job -> job.getDate().getMonth() == currentMonth) // Filter jobs by current month
                .collect(Collectors.groupingBy(
                        Jobs::getStatus, 
                        Collectors.counting()
                ));
    }
}

