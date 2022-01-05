package experiment;

/**
 * Represents a single flip of a coin where heads is represented by a double value of 1 and tails
 * by a double value of 0.
 */
public class CoinFlipExperiment implements Experiment {
  private final double probHeads;

  /**
   * Constructs a CoinFlipExperiment that models flipping a fair coin, where the
   * probability of flipping heads is 0.5 and the probability of flipping tails is 0.5.
   */
  public CoinFlipExperiment() {
    this(0.5);
  }

  /**
   * Constructs a CoinFlipExperiment that models flipping a coin that is biased towards
   * head with the probability specified by the user.
   *
   * @param probHeads the probability of flipping heads
   * @throws IllegalArgumentException if probHeads is not in the range [0.0, 1.0]
   */
  public CoinFlipExperiment(double probHeads) {
    if (probHeads < 0.0 || 1.0 < probHeads) {
      throw new IllegalArgumentException("The value of the bias must be in the range [0.0, 1.0]");
    }

    this.probHeads = probHeads;
  }

  @Override
  public double runExperiment() {
    // if Math.random() in [0.0, this.probHeads) -> Heads; else Tails
    return Math.random() < this.probHeads ? 1.0 : 0.0;
  }

  @Override
  public String toString() {
    return String.format("Coin Flip (Bias for Heads = %.3f)", this.probHeads);
  }
}
