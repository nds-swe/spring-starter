package ch.abbts.nds.swe.swdt.starter.skill;

import java.util.List;

public interface Sortable<T> {
  public List<T> sort(List<T> input);
}
