package ch.abbts.nds.swe.swdt.starter.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillsController {

  Logger logger = LoggerFactory.getLogger(SkillsController.class);

  @GetMapping(produces = "application/json")
  public List<String> skills(@RequestParam(name = "order", required = false, defaultValue = "ASC") String order) {
    logger.info("Param order=" + order);
    return Arrays.asList("expedition-arctic",
        "ice-climbing",
        "language-hispanic",
        "language-english",
        "heavy-machinery",
        "special-drillhead-rtx3300");
  }
}