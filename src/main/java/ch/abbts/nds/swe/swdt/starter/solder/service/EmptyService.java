package ch.abbts.nds.swe.swdt.starter.solder.service;

import ch.abbts.nds.swe.swdt.starter.solder.persistence.EmptyDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmptyService {

  @Autowired
  private EmptyDb db;

  public String getData(){
    return db.data();
  }

}
