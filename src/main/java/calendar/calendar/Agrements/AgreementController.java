package calendar.calendar.Agrements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aggrements")
public class AgreementController {

    @Autowired
    private AgreementRepository agreementRepository;

    @GetMapping
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }

 }

