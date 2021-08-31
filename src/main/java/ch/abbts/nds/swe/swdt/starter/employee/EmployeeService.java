package ch.abbts.nds.swe.swdt.starter.employee;

import ch.abbts.nds.swe.swdt.starter.UnleashService;
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

  @Autowired
  private UnleashService unleash;

  public List<Employee> getEmployees() {
    if(unleash.getUnleash().isEnabled("reverse-sort")) {
      return Arrays.asList(new Employee("These", 22),
          new Employee("Are New", 28),
          new Employee("Names, what?", 38));
    } else {
      return Arrays.asList(new Employee("Edmund", 22),
          new Employee("Tenzing", 28),
          new Employee("Dominik", 38));
    }

  }

}
