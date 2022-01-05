package experiment;

/**
 * An experiment represents a single trial of a statistical experiment (i.e. a single coin flip
 * or random selection from a list); an experiment may vary by the type, but should all have
 * the functionality to be run and return the value of a single run of the experiment.
 */
public interface Experiment {

  /**
   * Runs this experiment once and returns a value representing its outcome.
   *
   * @return a double value representing the outcome of running the experiment once
   */
  double runExperiment();
}
