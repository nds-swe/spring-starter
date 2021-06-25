package ch.abbts.nds.swe.swdt.starter.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class SortingFactory {

  Logger logger = LoggerFactory.getLogger(SkillsController.class);

  @Autowired
  @Qualifier("ascendingStringOrderImpl")
  private Sortable ascendingStrategy = new AscendingStringOrderImpl();

  @Autowired
  @Qualifier("descendingStringOrderImpl")
  private Sortable descendingStrategy = new DescendingStringOrderImpl();

  private Sortable[] collect(){
    return new Sortable[]{ascendingStrategy, descendingStrategy};
  }

  public Sortable getSortOrder(String order) {
    Sortable[] strategies = this.collect();
    Optional<Sortable> strategy = Arrays.stream(strategies).filter(sortable -> sortable.supports(order)).findFirst();
    if (strategy.isPresent()){
      return strategy.get();
    } else {
      logger.info("No sort order provided, using 'ASC'");
      return ascendingStrategy;
    }
  }
}
