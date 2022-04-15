package step;

import domain.Cities;
import domain.Individual;
import domain.Pair;
import lombok.val;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Incubator {

    private static final int NUMBER_OF_CITIES = Cities.values().length;

//    private final MutationService mutationService = new MutationService();
    private final SecureRandom random = new SecureRandom();

    public List<Individual> produceChildren(final List<Pair<Individual>> pairs) {
        return pairs.stream()
                // Step 3 - produce children
                .flatMap(produceChildren())
                // Step 4 - optional mutation (based on random number)
//                .map(child -> mutationService.shouldMutate() ? mutationService.mutate(child) : child)
                // creating Individuals from produced children
//                .map(child -> new Individual(Integer.parseInt(child, 2)))
                .collect(Collectors.toList());
    }

    private Function<Pair<Individual>, Stream<? extends Individual>> produceChildren() {
        return pair -> {
            val first = pair.getFirst().getCities();
            val second = pair.getSecond().getCities();

            val firstDelimiter = random.nextInt(NUMBER_OF_CITIES - 1);
            val secondDelimiter = firstDelimiter + random.nextInt(NUMBER_OF_CITIES - firstDelimiter);

            val static1 = first.subList(firstDelimiter, secondDelimiter);

            val head1 = new ArrayList<Cities>();

            int index = 1;
            val tail1 = new ArrayList<Cities>();

            // combine everything


            // same for 2nd part

//            return Stream.of(binaryChildren1, binaryChildren2);
        };
    }
}
