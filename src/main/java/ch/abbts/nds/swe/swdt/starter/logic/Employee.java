package ch.abbts.nds.swe.swdt.starter.logic;

public class Employee {
  private Integer age;

  public Employee(Integer age) {
    this.age = age;
  }

  public boolean isOfAge(Integer age) {
    return this.age >= age;
  }
}
