package com.example.Software.project.Service.Counts;


import java.time.LocalDate;
// import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Software.project.Repo.Customer.CustomerRepo;
import com.example.Software.project.Repo.Employee.EmployeesRepository;
import com.example.Software.project.Repo.Item.ItemRepo;
import com.example.Software.project.Repo.Jobs.JobsRepository;
import com.example.Software.project.Repo.Unit.UnitRepo;
import com.example.Software.project.Repo.Visits.VisitsRepository;
import com.example.Software.project.Repo.Vehicle.VehicleRepo;

// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

@Service
public class CountsService {

    private final UnitRepo unitsRepository;

    private final JobsRepository jobsRepository;

    private final VehicleRepo vehiclesRepository;

    private final ItemRepo itemsRepository;

    private final CustomerRepo customersRepository;

    private final EmployeesRepository employeesRepository;

    private final VisitsRepository visitsRepository;

    public CountsService(UnitRepo unitsRepository, JobsRepository jobsRepository, VehicleRepo vehiclesRepository, ItemRepo itemsRepository, CustomerRepo customersRepository, EmployeesRepository employeesRepository, VisitsRepository visitsRepository) {
        this.unitsRepository = unitsRepository;
        this.jobsRepository = jobsRepository;
        this.vehiclesRepository = vehiclesRepository;
        this.itemsRepository = itemsRepository;
        this.customersRepository = customersRepository;
        this.employeesRepository = employeesRepository;
        this.visitsRepository = visitsRepository;
    }

    public long getUnitsCount() {
        return unitsRepository.count();
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

//calculates the start and end dates of the current month and get the count

    public long getCurrentMonthVisitsCount() {
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfMonth = currentDate.withDayOfMonth(1); // First day of the current month
        LocalDate endOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth()); // Last day of the current month
        return visitsRepository.countByDateBetween(startOfMonth, endOfMonth);
    }

    public long getCurrentMonthJobsCount() {
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfMonth = currentDate.withDayOfMonth(1); // First day of the current month
        LocalDate endOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth()); // Last day of the current month
        return jobsRepository.countByDateBetween(startOfMonth, endOfMonth);
    }
    
    
}
