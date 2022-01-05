import experiment.CoinFlipExperiment;
import experiment.Experiment;
import simulation.BasicSimulation;
import simulation.Simulation;

/**
 * Allows the user to run the statistical simulation based on the experiment and simulation
 * defined in this class.
 */
public final class SimulationDriver {
  static Simulation simulation = new BasicSimulation();

  static Experiment fairCoinFlip = new CoinFlipExperiment();
  static Experiment biasedCoinFlip = new CoinFlipExperiment(0.75);
  static Experiment onlyHeadsCoinFlip = new CoinFlipExperiment(1.0);

  // Runs the simulation and prints the results to the console
  public static void main(String[] args) {
    Experiment[] experiments = new Experiment[]{fairCoinFlip, biasedCoinFlip, onlyHeadsCoinFlip};

    // run 1 trial each of the experiments
    for (var experiment : experiments) {
      System.out.printf("%s: %.2f%n", experiment, experiment.runExperiment());
    }

    // run each of the experiments 200,000 times with 100 trials each
    for (var experiment : experiments) {
      simulation.setExperiment(experiment);
      simulation.runSimulation(200000, 100);
    }
  }

}
