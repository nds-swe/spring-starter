package ch.abbts.nds.swe.swdt.starter.skill;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SkillsRepository {
  public List<String> skills() {
    return Arrays.asList("expedition-arctic",
        "ice-climbing",
        "language-hispanic",
        "language-english",
        "heavy-machinery",
        "special-drillhead-rtx3300");
  }
}
