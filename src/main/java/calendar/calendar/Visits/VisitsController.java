package calendar.calendar.Visits;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/visits")
public class VisitsController {

    @Autowired
    private VisitsService visitsService;


    @GetMapping
    public Map<String, Long> getCurrentMonthStatus() {
        return visitsService.getCurrentMonthStatus();
    }
}
