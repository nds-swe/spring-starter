package ch.abbts.nds.swe.swdt.starter.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class LogWarmer {
  private static final Logger LOG = LoggerFactory.getLogger(LogWarmer.class);

  @PostConstruct
  public void init() {
    LOG.trace("Starting procedure to add a new expedition.");
    LOG.debug("Adding expedition with name = {}.", "ExPediTi0nName");
    LOG.trace("Creating the expedition using the {} factory", "ArcticExpedition.class");
    LOG.info("Expedition {} created", 12345);
    LOG.debug("Adding {} scientists to the expedition {}", Arrays.asList("fred", "george"), 12345);
    LOG.warn("{} is not qualified to take part in {}", "fred", 12345);
    LOG.error("Adding expedition failed", new RuntimeException("UNQUALIFIED_PARTICIPANT"));
  }

}
