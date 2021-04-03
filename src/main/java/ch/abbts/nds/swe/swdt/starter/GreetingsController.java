package ch.abbts.nds.swe.swdt.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/greet")
public class GreetingsController {
  @GetMapping(path = "/", produces = "application/text")
  public String greet() {
    return "Greetings";
  }
}