package apps.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<T> {

    private final T first;
    private final T second;

    public Pair(final T first, final T second) {
        this.first = first;
        this.second = second;
    }
}
