package ch.abbts.nds.swe.swdt.starter.expedition;

public class ArcticExpedition extends Expedition {
  public ArcticExpedition(String name) {
    this.name = name;
    this.type = "arctic";
  }

  @Override
  public String getPackagingPreference() {
    return "rather cold";
  }

  @Override
  Integer getMaxWeight() {
    return 2000;
  }
}