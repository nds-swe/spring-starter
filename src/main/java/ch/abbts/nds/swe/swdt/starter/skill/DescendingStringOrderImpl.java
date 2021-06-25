package ch.abbts.nds.swe.swdt.starter.skill;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DescendingStringOrderImpl implements Sortable<String> {

  @Override
  public List<String> sort(List<String> input) {
    return input.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }
}
