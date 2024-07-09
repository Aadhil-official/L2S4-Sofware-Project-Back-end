package com.example.Software.project.Service.JobAllocationModule;

import com.example.Software.project.Dto.JobAllocationModule.CustomerDTO;
import com.example.Software.project.Entity.JobAllocationModule.Customer;
import com.example.Software.project.Entity.JobAllocationModule.JobListEntity;
import com.example.Software.project.Entity.JobAllocationModule.TeamMemberEntity;
import com.example.Software.project.Repo.JobAllocationModule.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServise {

    @Autowired
    private CustomerRepository customerRepository;

    public static List<JobListEntity> getAllMembers() {
        return getAllMembers();
    }

    @Transactional
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerPhone(customerDTO.getCustomerPhone());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setVehicleNumber(customerDTO.getVehicleNumber());
        customer.setInvoiced(customerDTO.getInvoiced());
        customer.setDateAndTime(customerDTO.getDateAndTime());
        customer.setToBeInvoiced(customerDTO.getToBeInvoiced());

        List<TeamMemberEntity> teamMembers = customerDTO.getTeamMembers().stream().map(dto -> {
            TeamMemberEntity teamMember = new TeamMemberEntity();
            teamMember.setEmployeeName(dto.getEmployeeName());
            teamMember.setEmployeePhone(dto.getEmployeePhone());
            teamMember.setEmployeeDesignation(dto.getEmployeeDesignation());
            teamMember.setEmployeeEmail(dto.getEmployeeEmail());
            teamMember.setCustomer(customer);
            return teamMember;
        }).collect(Collectors.toList());

        customer.setTeamMembers(teamMembers);

        customerRepository.save(customer);
    }
}
