package ch.abbts.nds.swe.swdt.starter.skill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Tag("unit")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SkillServiceTest {

  final String[] skills = new String[]{
      "expedition-tropic",
      "ice-sledging",
      "language-portuguese",
      "language-japanese",
      "light-machinery",
      "special-drillhead-rtx5500",
  };

  @InjectMocks
  @Autowired
  private SkillsService skillsService;

  @Mock
  private SkillsRepository skillsRepository;

  @BeforeEach
  public void initMocks(){
    MockitoAnnotations.openMocks(this);
    Mockito.when(skillsRepository.skills()).thenReturn(Arrays.asList(skills));
  }

  @Test
  @DisplayName("Ensure that repository is mocked")
  public void ensure_mock(){
    List<String> skillResult = skillsService.sort("ASC");
    assertThat(skillResult).doesNotContain("language-hispanic");
  }

  @Test
  @DisplayName("ASC")
  public void asc(){
    List<String> skillResult = skillsService.sort("ASC");
    String[] ascending = skills.clone();
    Arrays.sort(ascending);
    assertThat(skillResult).hasSize(6).containsExactly(ascending);
  }

  @Test
  @DisplayName("DESC")
  public void desc() {
    List<String> skillResult = skillsService.sort("DESC");
    String[] descending = skills.clone();
    Arrays.sort(descending, Collections.reverseOrder());
    assertThat(skillResult).hasSize(6).containsExactly(descending);
  }
}
