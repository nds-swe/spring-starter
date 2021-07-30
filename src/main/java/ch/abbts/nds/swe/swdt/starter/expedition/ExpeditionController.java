package ch.abbts.nds.swe.swdt.starter.expedition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpeditionController {
  Logger logger = LoggerFactory.getLogger(ExpeditionController.class);

  @PostMapping("/expeditions")
  ResponseEntity<Expedition> newExpedition(@RequestBody ArcticExpedition newExpedition) {
    logger.info("Will create new expedition {}", newExpedition);
    if ("arctic".equals(newExpedition.getType())) {
      return ResponseEntity.status(201).body(new ArcticExpedition(newExpedition.getName(), newExpedition.getType()));
    } else if ("desert".equals(newExpedition.getType())) {
      return ResponseEntity.status(201).body(new DesertExpedition(newExpedition.getName(), newExpedition.getType()));
    } else {
      logger.error("This expedition type [{}] is not supported", newExpedition.getType());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }
}