package de.c_peper.kata.rover;

import lombok.*;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@EqualsAndHashCode
@AllArgsConstructor
public class Position {
    protected Integer x;

    protected Integer y;

    public Boolean equals(Integer x, Integer y) {
        return equals(new Position(x, y));
    }
}
