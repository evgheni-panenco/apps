package apps.domain;

import apps.util.Equation;
import lombok.Getter;
import lombok.Setter;

import static apps.util.BinaryUtil.toBinaryForm;

@Getter
@Setter
public class Individual {

    private int x;
    private String binaryRepresentation;
    private int quality;

    public Individual(final int x) {
        this.x = x;
        this.binaryRepresentation = toBinaryForm(x);
        this.quality = Equation.calculate(x);
    }
}
