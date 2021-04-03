package ch.abbts.nds.swe.swdt.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/secure-greet")
public class SecureGreetingsController {
  @GetMapping(path = "/", produces = "application/text")
  public String greet() {
    return "Secure greetings, I am only visible with an Authorization (or should be)";
  }
}