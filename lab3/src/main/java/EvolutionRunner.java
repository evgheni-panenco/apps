import domain.Individual;
import lombok.val;
import step.InitialPopulationCreator;
import step.MatchMaker;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lab1 || y = -1 * (x – 6) * (x – 20) * (x – 38) * (x – 61)
 *
 * @author Evgheni Panenco
 * @group MIA2102
* */

public class EvolutionRunner {

    private static final int MAX_TIME_RESTRICTION = 10;
    private static final int INDIVIDUALS_IN_POPULATION = 4;
    private static final int MAX_POPULATION_NUMBER = 100;
    private static final int MAX_POSSIBLE_QUALITY = 180_000;
    private static final int MAX_NUMBER_OF_NON_PRODUCTIVE_POPULATIONS = 10;

    private static final MatchMaker matchMaker = new MatchMaker();
    private static final Incubator incubator = new Incubator();

    public static void main(String[] args) {
        val startTime = Instant.now();
        int numberOfGenerations = 0;

        double previousPopulationQuality = 0;
        int nonProductiveGenerations = 0;

        // Step1 - Create initial population
        var population = InitialPopulationCreator.initializeInitialPopulation();

        do {
            // Step2 - choose parents for breeding process
            val pairs = matchMaker.createPairs(population);

            // Step3 - Create children from chosen parents
            // Step4 - Optional mutation
            val children = incubator.produceChildren(pairs);

//            // Step5 - Extend population with children
//            population.addAll(children);
//
//            // Step6
//            population = population.stream()
//                    .sorted(Comparator.comparingInt(Individual::getQuality).reversed())
//                    .limit(4).collect(Collectors.toList());
//            numberOfGenerations++;
//
//            val currentPopulationQuality = population.stream()
//                    .map(Individual::getQuality)
//                    .reduce(0, Integer::sum).doubleValue();
//            System.out.println(numberOfGenerations + "|Population quality - " + currentPopulationQuality);
//            nonProductiveGenerations = Math.abs(currentPopulationQuality - previousPopulationQuality) <= 0.0001
//                    ? nonProductiveGenerations + 1 : 0;
//            previousPopulationQuality = currentPopulationQuality;
        } while (true);
//        } while (!checkStopCondition(population, startTime, numberOfGenerations, nonProductiveGenerations));
//
//        printFinalResults(population, numberOfGenerations);
    }

//    private static void printFinalResults(List<Individual> population, int numberOfGenerations) {
//        System.out.println("\n\n");
//        population.forEach(individual -> {
//            System.out.println("###");
//            System.out.println("Individual value = " + individual.getX());
//            System.out.println("Individual quality = " + individual.getQuality());
//            System.out.println("###");
//        });
//        System.out.println("\nFinal population contains " + population.size() + " individuals");
//        System.out.println("\nNumber of generations " + numberOfGenerations);
//    }
//
//    private static boolean checkStopCondition(List<Individual> population, Instant startTime, int numberOfGenerations, int nonProductiveGeneration) {
//        val isMetTimeStopCondition = Duration.between(startTime, Instant.now()).getSeconds() > MAX_TIME_RESTRICTION;
//        val isMetNumberOfPopulationStopCondition = numberOfGenerations > MAX_POPULATION_NUMBER;
//        val isMetPopulationQualityStopCondition = population.stream()
//                .filter(individual -> individual.getQuality() >= MAX_POSSIBLE_QUALITY)
//                .count() == INDIVIDUALS_IN_POPULATION;
//        val isNonProductiveForLongTime = nonProductiveGeneration >= MAX_NUMBER_OF_NON_PRODUCTIVE_POPULATIONS;
//
//        return isMetTimeStopCondition || isMetNumberOfPopulationStopCondition
//                || isMetPopulationQualityStopCondition || isNonProductiveForLongTime;
//    }
}
