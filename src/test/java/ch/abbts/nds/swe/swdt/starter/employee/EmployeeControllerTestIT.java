package ch.abbts.nds.swe.swdt.starter.employee;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class EmployeeControllerTestIT {
  @Test
  public void
  employee_resource_returns_200_with_expected_amount_of_employees() {
    given().
        auth().
        basic("user", "password").
    when().
        get("/employees/").
        then().
        statusCode(200).
        body("size()", is(5) // it must fail!!!
    );
  }
}
