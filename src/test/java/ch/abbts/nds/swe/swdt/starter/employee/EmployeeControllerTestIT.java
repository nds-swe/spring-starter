package ch.abbts.nds.swe.swdt.starter.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Tag("IT")
public class EmployeeControllerTestIT {
  @Test
  @DisplayName("/employees/ returns 200 and a 3 employees")
  public void
  employee_resource_returns_200_with_expected_amount_of_employees() {
    given().
        auth().
        basic("user", "password").
    when().
        get("/employees/").
        then().
        statusCode(200).
        body("size()", is(3)
    );
  }
}
