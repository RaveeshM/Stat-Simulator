package simulation;

import experiment.Experiment;

/**
 * A simulation.Simulation replicates the conditions of an experiment with a binary outcome (i.e. yes or no,
 * state A or state B, etc.) that can be modeled by the program and should have the functionality
 * to setup, run and provide information about this experiment.
 */
public interface Simulation {
  /**
   * Sets the experiment.Experiment that can be run in this simulation.Simulation.
   *
   * @param e the experiment that can be run in this simulation.Simulation
   * @throws IllegalArgumentException if the provided experiment is null
   */
  void setExperiment(Experiment e) throws IllegalArgumentException;

  /**
   * Allows the user to determine whether a summary of statistics generated after a run of the
   * simulation will be printed to the console or not; the default value is true, meaning a summary
   * will be show after running the {@code run(simCount, trialCount)} method.
   */
  void setSummary(boolean b);

  /**
   * Runs the simulation "simCount" times and in each run of the simulation, runs the experiment
   * "trialCount" times; then, returns the sample mean of the sampling distribution.
   *
   * @param trialCount the number of times to run the trial
   * @return a double value representing the mean of the mean values calculated each run
   * @throws IllegalArgumentException if the given value of simCount or trialCount is non-positive
   * @throws IllegalStateException    if no experiment is set in the simulation.Simulation
   */
  double runSimulation(int simCount, int trialCount) throws IllegalArgumentException, IllegalStateException;
}
