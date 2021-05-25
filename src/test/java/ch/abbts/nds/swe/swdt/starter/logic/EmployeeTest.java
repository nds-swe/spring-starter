package ch.abbts.nds.swe.swdt.starter.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmployeeTest {
  @Test
  @DisplayName("Is too young")
  @Tag("unit")
  public void tooYoung() {
    Employee employee = new Employee("A", 12);
    assertFalse(employee.isOfAge(22), "Too young returns false");
  }

  @Test
  @DisplayName("Old enough")
  @Tag("unit")
  public void oldEnough() {
    Employee employee = new Employee("A",24);
    assertTrue(employee.isOfAge(22), "Old enough returns true");
  }

  @Test
  @DisplayName("Of exact age")
  @Tag("unit")
  public void exactAge() {
    Employee employee = new Employee("A",24);
    assertTrue(employee.isOfAge(24), "Exact age must also return true");
  }
}
