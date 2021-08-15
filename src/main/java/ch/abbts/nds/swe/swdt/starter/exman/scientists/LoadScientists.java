package ch.abbts.nds.swe.swdt.starter.exman.scientists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadScientists {

  private static final Logger log = LoggerFactory.getLogger(LoadScientists.class);

  @Bean
  CommandLineRunner initScientists(ScientistRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Scientist("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Scientist("Frodo Baggins", "thief")));
    };
  }
}