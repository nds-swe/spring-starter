package ch.abbts.nds.swe.swdt.starter.exman.scientists;

class ScientistNotFoundException extends RuntimeException {
  ScientistNotFoundException(Long id) {
    super("Could not find scientist " + id);
  }
}
