package calendar.calendar.Visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.dashboard.Jobs.Jobs;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VisitsService {

    @Autowired
    private VisitsRepository visitsRepository;


    public Map<String, Long> getCurrentMonthStatus() {
        List<Visits> visits = visitsRepository.findAll();
        Month currentMonth = LocalDate.now().getMonth();

        return visits.stream()
                .filter(job -> job.getDate().getMonth() == currentMonth) // Filter jobs by current month
                .collect(Collectors.groupingBy(
                    Visits::getStatus, 
                        Collectors.counting()
                ));
    }
}

