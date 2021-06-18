package ch.abbts.nds.swe.swdt.starter.employee;

import ch.abbts.nds.swe.swdt.starter.logic.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeesController {

  @Autowired
  private EmployeeService serv;

  @GetMapping(path = "/", produces = "application/json")
  public List<Employee> employees() {
    return serv.getEmployees();
  }
}