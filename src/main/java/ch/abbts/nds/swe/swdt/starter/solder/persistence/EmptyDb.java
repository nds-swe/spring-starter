package ch.abbts.nds.swe.swdt.starter.solder.persistence;

import org.springframework.stereotype.Component;

@Component
public class EmptyDb {
  public String data(){
    return "I am from the lowest layer.";
  }
}
