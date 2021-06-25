package ch.abbts.nds.swe.swdt.starter.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillsService {

  @Autowired
  private SkillsRepository skillsRepository;

  @Autowired
  private SortingFactory sortingFactory;

  public List<String> sort(String order) {
    List<String> skills = skillsRepository.skills();
    Sortable sortStrategy = sortingFactory.getSortOrder(order);
    return sortStrategy.sort(skills);
  }
}