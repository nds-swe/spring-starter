package ch.abbts.nds.swe.swdt.starter.skill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Tag("IT")
public class SkillControllerTestIT {

  // This test is a bit tricky to formulate as Integration Test because we do not have a database yet to mock
  final String[] skills = new String[]{
      "expedition-arctic",
      "ice-climbing",
      "language-hispanic",
      "language-english",
      "heavy-machinery",
      "special-drillhead-rtx3300",
  };

  @Test
  @DisplayName("/skills returns 200 and random elements")
  public void
  skill_resource_returns_200_with_random_skill_array() {
    given().
        auth().
        basic("user", "password").
        when().
        get("/skills").
        then().
        statusCode(200).
        body("size()", is(6)).
        body("$", hasItem("heavy-machinery"));
  }

  @Test
  @DisplayName("/skills returns 200 and ascending elements")
  public void
  skill_resource_returns_200_with_sorted_skill_array() {
    given().
        auth().
        basic("user", "password").
        queryParam("order", "ASC").
        when().
        get("/skills").
        then().
        statusCode(200).
        body("$", containsInRelativeOrder(Arrays.stream(skills).sorted().toArray())
        );
  }

  @Test
  @DisplayName("/skills returns 200 and descending elements")
  public void
  skill_resource_returns_200_with_reverse_sorted_skill_array() {
    given().
        auth().
        basic("user", "password").
        queryParam("order", "DESC").
        when().
        get("/skills").
        then().
        statusCode(200).
        body("$", containsInRelativeOrder(Arrays.stream(skills).sorted(Comparator.reverseOrder()).toArray())
        );
  }
}
