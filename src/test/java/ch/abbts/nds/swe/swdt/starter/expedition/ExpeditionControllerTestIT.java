package ch.abbts.nds.swe.swdt.starter.expedition;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Tag("IT")
public class ExpeditionControllerTestIT {
  @Test
  @DisplayName("POST /expeditions/ returns 201 and creates an expedition")
  public void
  expedition_resource_returns_201() {
    Map<String, Object> jsonAsMap = new HashMap<>();
    jsonAsMap.put("type", "arctic");
    jsonAsMap.put("name", "arctic-trip-2021");
    given().
        auth().
        basic("user", "password").
        contentType(ContentType.JSON).
        body(jsonAsMap).
      when().
        post("/expeditions/").
        then().
        statusCode(201);
  }

  @Test
  @DisplayName("POST /expeditions/ returns 400")
  public void
  expedition_resource_returns_400() {
    Map<String, Object> jsonAsMap = new HashMap<>();
    jsonAsMap.put("type", "imaginary-type");
    jsonAsMap.put("name", "arctic-trip-2021");
    given().
        auth().
        basic("user", "password").
        contentType(ContentType.JSON).
        body(jsonAsMap).
      when().
        post("/expeditions/").
        then().
        statusCode(400);
  }
}
