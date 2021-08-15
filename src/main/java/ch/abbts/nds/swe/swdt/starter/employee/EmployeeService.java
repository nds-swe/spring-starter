package ch.abbts.nds.swe.swdt.starter.employee;

import ch.abbts.nds.swe.swdt.starter.logic.Employee;
import ch.abbts.nds.swe.swdt.starter.solder.persistence.EmptyDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class EmployeeService {

  @Autowired
  private EmptyDb db;

  public List<Employee> getEmployees() {
    return Arrays.asList(new Employee[]{
        new Employee("Edmund", 22),
        new Employee("Tenzing", 28),
        new Employee("Dominik", 38),
    });
  }

}
