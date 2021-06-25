package ch.abbts.nds.swe.swdt.starter.skill;

import org.hamcrest.Matchers;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Tag("unit")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext
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
    List<String> skills = skillsService.sort("ASC");
    assertThat(skills, Matchers.<Collection<String>>allOf(
        not(
            contains("language-hispanic")
        )
    ));
  }

  @Test
  @DisplayName("ASC")
  public void asc(){
    List<String> skills = skillsService.sort("ASC");
    assertThat(skills, Matchers.<Collection<String>>allOf(
        hasSize(greaterThan(2)),
        contains(skills.stream().sorted().toArray())
    ));
  }

  @Test
  @DisplayName("DESC")
  public void desc() {
    List<String> skills = skillsService.sort("DESC");
    assertThat(skills, Matchers.<Collection<String>>allOf(
        hasSize(greaterThan(2)),
        contains(skills.stream().sorted(Comparator.reverseOrder()).toArray())
    ));
  }
}
