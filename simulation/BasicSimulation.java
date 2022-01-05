package simulation;

import java.util.Arrays;

import experiment.Experiment;

/**
 * Represents a Simulation with the ability to run an Experiment a certain number of times and
 * returns the sample mean of the sampling distribution and other statistics, if prompted.
 */
public class BasicSimulation implements Simulation {
  private Experiment experiment;
  private boolean showSummary;

  /**
   * Constructs a BasicSimulation without any arguments; Experiments may be changed/defined
   * prior to running the simulation.
   */
  public BasicSimulation() throws IllegalArgumentException {
    this.experiment = null;
    this.showSummary = true;
  }

  /**
   * Constructs a BasicSimulation using the given Experiment.
   * @param e the experiment to run
   * @throws IllegalArgumentException if the given Experiment is null
   */
  public BasicSimulation(Experiment e) throws IllegalArgumentException {
    if (e == null) throw new IllegalArgumentException("Provide a non-null experiment");

    this.experiment = e;
    this.showSummary = true;
  }

  @Override
  // allows users to change experiments without creating a new instance of this class
  public void setExperiment(Experiment e) throws IllegalArgumentException {
    if (e == null) throw new IllegalArgumentException("Provide a non-null experiment");

    this.experiment = e;
  }

  @Override
  public void setSummary(boolean b) {
    this.showSummary = b;
  }

  @Override
  public double runSimulation(int simCount, int trialCount) throws IllegalArgumentException, IllegalStateException {
    // checks the conditions prior to running the experiment
    if (simCount <= 0 || trialCount <= 0) {
      throw new IllegalArgumentException("Simulation and trial counts must be positive values");
    }

    if (this.experiment == null) {
      throw new IllegalStateException("Set an experiment before running");
    }

    // if valid, runs the simulation
    double[] samples = new double[simCount];
    
    for (int i = 0; i < simCount; i++) {
      double[] trialObservations = new double[trialCount];
      for (int j = 0; j < trialCount; j++) {
        trialObservations[j] = this.experiment.runExperiment();
      }
      
      samples[i] = this.calculateMean(trialObservations);
    }

    if (this.showSummary) this.printSummary(samples);
    return this.calculateMean(samples);
  }

  // calculates the mean by summing the observations and dividing by the number of observations
  private double calculateMean(double[] dataset) {
    return Arrays.stream(dataset).reduce(0, Double::sum) / dataset.length;
  }

  // prints a summary of statistics given the dataset of samples
  private void printSummary(double[] dataset) {
    // trivially calculated values
    int n = dataset.length;
    double mean = this.calculateMean(dataset);

    // initialized variables for values to calculate
    double sumDev = 0.0;

    for (var sample : dataset) {
      sumDev += Math.pow(sample - mean, 2);
    }

    double stdev = Math.pow(sumDev / (n - 1), 0.5);
    double error = stdev / Math.pow(n, 0.5);

    System.out.printf("STATISTICAL SUMMARY FOR EXPERIMENT: %s (n = %d)%n" +
                      "Sample Mean of the Sampling Distribution: %.3f%n" +
                      "Sample Standard Deviation of the Sampling Distribution: %.3f%n" +
                      "Standard Error of the Sampling Distribution: %f%n%n",
                      this.experiment, n, mean, stdev, error);
  }
}
