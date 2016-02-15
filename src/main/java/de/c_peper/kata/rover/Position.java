package de.c_peper.kata.rover;

import lombok.*;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@EqualsAndHashCode
@AllArgsConstructor
public class Position {
    protected Integer x;

    protected Integer y;

}
