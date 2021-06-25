package ch.abbts.nds.swe.swdt.starter.skill;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("descendingStringOrderImpl")
public class DescendingStringOrderImpl implements Sortable<String> {

  @Override
  public List<String> sort(List<String> input) {
    return input.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }

  @Override
  public boolean supports(String input) {
    return "DESC".equals(input);
  }
}
