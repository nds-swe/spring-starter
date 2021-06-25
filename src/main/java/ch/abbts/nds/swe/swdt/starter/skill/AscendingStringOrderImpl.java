package ch.abbts.nds.swe.swdt.starter.skill;

import java.util.List;
import java.util.stream.Collectors;

public class AscendingStringOrderImpl implements Sortable<String> {

  @Override
  public List<String> sort(List<String> input) {
    return input.stream().sorted().collect(Collectors.toList());
  }
}
