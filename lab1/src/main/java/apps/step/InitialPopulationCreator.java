package apps.step;

import apps.domain.Individual;

import java.util.ArrayList;
import java.util.List;

public class InitialPopulationCreator {

    // y = (-1) * (x - 6) * (x - 20) * (x - 38) * (x - 61)
    public static List<Individual>  initializeInitialPopulation() {
        return new ArrayList<>(List.of(new Individual[]{
                new Individual(6),
                new Individual(20),
                new Individual(38),
                new Individual(61)
        }));
    }
}
