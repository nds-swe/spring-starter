package ch.abbts.nds.swe.swdt.starter.skill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SortingFactory {

  Logger logger = LoggerFactory.getLogger(SortingFactory.class);

  @Autowired
  @Qualifier("ascendingStringOrderImpl")
  private Sortable ascendingStrategy;

  @Autowired
  @Qualifier("descendingStringOrderImpl")
  private Sortable descendingStrategy;

  private final List<Sortable> sortables;

  public SortingFactory(@Autowired List<Sortable> sortables) {
    this.sortables = sortables;
  }

  public Sortable getSortOrder(String order) {
    Optional<Sortable> strategy = this.sortables.stream().filter(sortable -> sortable.supports(order)).findFirst();
    if (strategy.isPresent()){
      return strategy.get();
    } else {
      logger.info("No sort order provided, using 'ASC'");
      return ascendingStrategy;
    }
  }
}
