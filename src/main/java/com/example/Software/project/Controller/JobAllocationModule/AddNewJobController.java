

package com.example.Software.project.Controller.JobAllocationModule;


import com.example.Software.project.Service.JobAllocationModule.CustomerServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Software.project.Dto.JobAllocationModule.CustomerDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AddNewJobController {


    private final CustomerServise CustomerServise;

    @Autowired
    public AddNewJobController(CustomerServise customerServise) {
        this.CustomerServise = customerServise;
    }

    @PostMapping("/addNewJob")
    public String createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerServise.saveCustomer(customerDTO);
        return "Customer saved successfully!";
    }
}
