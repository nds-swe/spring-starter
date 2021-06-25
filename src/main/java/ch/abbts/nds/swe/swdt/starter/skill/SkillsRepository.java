package ch.abbts.nds.swe.swdt.starter.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SkillsRepository {
  Logger logger = LoggerFactory.getLogger(SkillsRepository.class);
  public List<String> skills() {
    logger.info("Repository called.");
    return Arrays.asList("expedition-arctic",
        "ice-cldasfimbing",
        "languageasdf-hispanic",
        "languageasdf-english",
        "heavy-macasdfhinery",
        "special-drasdfillhead-rtx3300");
  }
}
