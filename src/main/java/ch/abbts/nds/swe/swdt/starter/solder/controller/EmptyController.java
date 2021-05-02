package ch.abbts.nds.swe.swdt.starter.solder.controller;

import ch.abbts.nds.swe.swdt.starter.solder.service.EmptyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/empty")
public class EmptyController {

  @Autowired
  private EmptyService serv;

  @GetMapping(path = "/", produces = "application/text")
  public String empty() {
    return serv.getData();
  }
}