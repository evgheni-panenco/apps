package apps.step;

import apps.domain.Individual;
import apps.domain.Pair;
import lombok.val;

import java.security.SecureRandom;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static apps.util.BinaryUtil.BITS_NUMBER;

public class Incubator {

    private final MutationService mutationService = new MutationService();
    private final SecureRandom random = new SecureRandom();

    public List<Individual> produceChildren(final List<Pair<Individual>> pairs) {
        return pairs.stream()
                // Step 3 - produce children
                .flatMap(produceChildren())
                // Step 4 - optional mutation (based on random number)
                .map(child -> mutationService.shouldMutate() ? mutationService.mutate(child) : child)
                // creating Individuals from produced children
                .map(child -> new Individual(Integer.parseInt(child, 2)))
                .collect(Collectors.toList());
    }

    private Function<Pair<Individual>, Stream<? extends String>> produceChildren() {
        return pair -> {
            val binaryForm1 = pair.getFirst().getBinaryRepresentation();
            val binaryForm2 = pair.getSecond().getBinaryRepresentation();
            val delimiterIndex = random.nextInt(BITS_NUMBER);

            val binaryChildren1 = binaryForm1.substring(0, delimiterIndex)
                    + binaryForm2.substring(delimiterIndex, BITS_NUMBER);
            val binaryChildren2 = binaryForm2.substring(0, delimiterIndex)
                    + binaryForm1.substring(delimiterIndex, BITS_NUMBER);

            return Stream.of(binaryChildren1, binaryChildren2);
        };
    }
}
