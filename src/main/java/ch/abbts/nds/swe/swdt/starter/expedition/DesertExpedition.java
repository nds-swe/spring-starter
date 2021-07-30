package ch.abbts.nds.swe.swdt.starter.expedition;

public class DesertExpedition implements Expedition {

  private String name;
  private String type;

  DesertExpedition() {
  }

  public DesertExpedition(String name, String type) {

    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String getSlogan() {
    return "Desert, *sweat*.";
  }
}