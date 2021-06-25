package ch.abbts.nds.swe.swdt.starter.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillsController {

  Logger logger = LoggerFactory.getLogger(SkillsController.class);

  @Autowired
  private SkillsService skillsService;

  @GetMapping(produces = "application/json")
  public List<String> skills(@RequestParam(name = "order", required = false, defaultValue = "ASC") String order) {
    return skillsService.sort(order);
  }
}