package ch.abbts.nds.swe.swdt.starter.skill;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("ascendingStringOrderImpl")
public class AscendingStringOrderImpl implements Sortable<String> {

  @Override
  public List<String> sort(List<String> input) {
    return input.stream().sorted().collect(Collectors.toList());
  }

  @Override
  public boolean supports(String input) {
    return "ASC".equals(input);
  }
}
