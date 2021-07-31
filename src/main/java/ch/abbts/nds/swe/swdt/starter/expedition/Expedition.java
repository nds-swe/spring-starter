package ch.abbts.nds.swe.swdt.starter.expedition;

public abstract class Expedition {
  protected String name;
  protected String type;

  Expedition() {
  }

  public Expedition(String name, String type) {
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

  abstract String getPackagingPreference();

  abstract Integer getMaxWeight();
}
