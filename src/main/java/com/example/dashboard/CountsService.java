package com.example.dashboard;
import com.example.dashboard.Units.*;
import com.example.dashboard.Vehicles.VehiclesRepository;
import com.example.dashboard.Customers.CustomersRepository;
import com.example.dashboard.Employees.EmployeesRepository;
import com.example.dashboard.Items.ItemsRepository;
import com.example.dashboard.Jobs.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CountsService {

@Autowired
    private UnitsRepository unitsRepository;

@Autowired
    private JobsRepository jobsRepository;

@Autowired
    private VehiclesRepository vehiclesRepository;

@Autowired
    private ItemsRepository itemsRepository;
    
@Autowired
    private CustomersRepository customersRepository;

@Autowired
    private EmployeesRepository employeesRepository;



    public long getUnitsCount() {
        return unitsRepository.count();
    }

    public long getJobsCount() {
        return jobsRepository.count();
    }

    public long getVehiclesCount() {
        return vehiclesRepository.count();
    }

    public long getItemsCount() {
        return itemsRepository.count();
    }

    public long getCustomersCount() {
        return customersRepository.count();
    }

    public long getEmployeesCount() {
        return employeesRepository.count();
    }
}

