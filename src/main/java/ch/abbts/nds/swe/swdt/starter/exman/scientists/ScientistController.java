package ch.abbts.nds.swe.swdt.starter.exman.scientists;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScientistController {

  private final ScientistRepository repository;

  ScientistController(ScientistRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/scientists")
  List<Scientist> all() {
    return repository.findAll();
  }

  @PostMapping("/scientists")
  Scientist newScientist(@RequestBody Scientist newScientist) {
    return repository.save(newScientist);
  }

  // Single item

  @GetMapping("/scientists/{id}")
  Scientist one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new ScientistNotFoundException(id));
  }

  @PutMapping("/scientists/{id}")
  Scientist replaceScientist(@RequestBody Scientist newScientist, @PathVariable Long id) {

    return repository.findById(id)
        .map(scientist -> {
          scientist.setName(newScientist.getName());
          scientist.setRole(newScientist.getRole());
          return repository.save(scientist);
        })
        .orElseGet(() -> {
          newScientist.setId(id);
          return repository.save(newScientist);
        });
  }

  @DeleteMapping("/scientists/{id}")
  void deleteScientist(@PathVariable Long id) {
    repository.deleteById(id);
  }
}