package ch.abbts.nds.swe.swdt.starter.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SortingFactory {

  Logger logger = LoggerFactory.getLogger(SkillsController.class);

  public Sortable getSortOrder(String order) {
    switch (order) {
      case "DESC":
        return new DescendingStringOrderImpl();
      case "ASC":
        return new AscendingStringOrderImpl();
      default:
        logger.info("No sort order provided, using 'ASC'");
        return new AscendingStringOrderImpl();
    }
  }
}
