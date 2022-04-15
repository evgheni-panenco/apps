package step;

import domain.Individual;
import domain.Pair;
import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchMaker {

    public List<Pair<Individual>> createPairs(final List<Individual> population) {
        val pairs = new ArrayList<Pair<Individual>>();
        Collections.shuffle(population);
        for (int i = 0; i < population.size() - 1; i += 2) {
            pairs.add(new Pair<>(population.get(i), population.get(i + 1)));
        }
        return pairs;
    }
}
