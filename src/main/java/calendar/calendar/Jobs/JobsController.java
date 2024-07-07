package calendar.calendar.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    private JobsService jobsService;

    @GetMapping
    public Map<String, Long> getCurrentMonthStatus() {
        return jobsService.getCurrentMonthStatus();
    }
}