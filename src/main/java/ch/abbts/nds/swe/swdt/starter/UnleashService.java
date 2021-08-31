package ch.abbts.nds.swe.swdt.starter;

import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.util.UnleashConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UnleashService implements EnvironmentAware {

  Logger logger = LoggerFactory.getLogger(UnleashService.class);

  private DefaultUnleash unleash;

  public DefaultUnleash getUnleash() {
    return this.unleash;
  }

  private Environment environment;

  public UnleashService(@Value("${unleash.api.token}") String token) {
    UnleashConfig unleashConfig = UnleashConfig.builder()
        .appName("my.java-app")
        .instanceId("your-instance-1")
        .environment("demo")
        .unleashAPI("http://unleash:4242/api")
        .customHttpHeader("Authorization", token)
        .build();

    this.unleash = new DefaultUnleash(unleashConfig);
    logger.info("Successfully acquired connection to Unleash.");
  }

  @Override
  public void setEnvironment(final Environment environment) {
    this.environment = environment;
  }
}
