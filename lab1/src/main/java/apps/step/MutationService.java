package apps.step;

import lombok.val;

import java.security.SecureRandom;

import static apps.util.BinaryUtil.BITS_NUMBER;

public class MutationService {

    private final SecureRandom random = new SecureRandom();

    public boolean shouldMutate() {
        return random.nextInt(10) == 1;
    }

    public String mutate(final String childrenBinaryForm) {
        val mutationPosition = random.nextInt(BITS_NUMBER);
        val currentGen = childrenBinaryForm.charAt(mutationPosition);
        val newGen = currentGen == '1' ? '0' : '1';
        return childrenBinaryForm.substring(0, mutationPosition)
                + newGen + childrenBinaryForm.substring(mutationPosition + 1, BITS_NUMBER);
    }

}
