package step;

import domain.Cities;
import domain.Individual;
import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitialPopulationCreator {

    private static final List<Cities> initialArray = List.of(
            Cities.A, Cities.B, Cities.C, Cities.D, Cities.E, Cities.F
    );

    public static List<Individual>  initializeInitialPopulation() {
        return new ArrayList<>(List.of(new Individual[]{
                new Individual(getShuffledCities()),
                new Individual(getShuffledCities()),
                new Individual(getShuffledCities()),
                new Individual(getShuffledCities())
        }));
    }

    private static List<Cities> getShuffledCities() {
        val cities = new ArrayList<>(initialArray);
        Collections.shuffle(cities);
        return cities;
    }
}
