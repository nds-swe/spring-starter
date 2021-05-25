package ch.abbts.nds.swe.swdt.starter.logic;

public class Employee {
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private Integer age;
  private String name;

  public Employee(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public boolean isOfAge(Integer age) {
    return this.age >= age;
  }
}
