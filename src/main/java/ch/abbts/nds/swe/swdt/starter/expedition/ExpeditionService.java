package ch.abbts.nds.swe.swdt.starter.expedition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExpeditionService {

  Logger logger = LoggerFactory.getLogger(ExpeditionService.class);

  Expedition addExpedition(ExpeditionDTO newExpedition) {
    logger.info("Will create new expedition {}", newExpedition);
    if ("arctic".equals(newExpedition.getType())) {
      return new ArcticExpedition(newExpedition.getName());
    } else if ("desert".equals(newExpedition.getType())) {
      return new DesertExpedition(newExpedition.getName());
    } else {
      return null;
    }
  }
}