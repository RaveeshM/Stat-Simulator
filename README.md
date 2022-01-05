# stat-simulator
A Java program that can be used to run simple statistical simulations

## How does it work?
The program consists of two main interfaces: `Experiment` and `Simulation`. An `Experiment` defines the problem or situation that is being modeled, where running the experiment represents 1 trial. For example, if you were modeling a coin flip, running the experiment represents a single flip of the coin (returning 0.0 for a tails and 1.0 for a heads). A `Simulation` runs a number of trials and finds the average of those trials, repeats that a for a certain number of runs and then finds the average of the averages (i.e. the sample mean of the sampling distribution).

## Where do I run the experiments?
For a single trial of an experiment, simply create an instance of the desired class and call the `runExperiment()` method. To run multiple trials and multiple runs of those trials, create an instance of the `BasicSimulation` class and set the experiment in the class to the desired experiment. An example of this is provided in the `SimulationDriver` class. 

## How do I add my experiment to this program?
To create a new experiment, create a new Java class that implements the `Experiment`. The `runExperiment()` method should return the double outcome of an experiment. If your experiment doesn't return an explicit value, try using values to represent certain outcomes. For example, A game with 3 outcomes (win, lose, tie) could be represented by a 1.0, 0.0 and 0.5, respectively. Additionally, overriding the `toString()` method with the name/description of your experiment can be helpful to use elsewhere in the program, but is not required.

## Can I add more statistics to the simulation?
The `BasicSimulation` only supports finding the sample mean, standard deviation, and standard error of the sampling distribution. To add more statistics or display them differently, you could create a new class that implements the `Simulation` interface and, if it is very similar to the `BasicSimulation`, the class can extend this class as well.
