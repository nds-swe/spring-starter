package ch.abbts.nds.swe.swdt.starter.expedition;

public class DesertExpedition extends Expedition {
  public DesertExpedition(String name) {
    this.name = name;
    this.type = "desert";
  }

  @Override
  public String getPackagingPreference() {
    return "rather warm";
  }

  @Override
  Integer getMaxWeight() {
    return 5000;
  }
}