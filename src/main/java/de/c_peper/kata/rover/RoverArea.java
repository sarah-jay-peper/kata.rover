package de.c_peper.kata.rover;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RoverArea {

    private final Integer minX;

    private final Integer minY;

    private final Integer maxX;

    private final Integer maxY;

    public static RoverArea getDefaultField() {
        return new RoverArea(0, 0, 10, 10);
    }

    public static RoverArea getZeroBasedField(Integer maxX, Integer maxY) {
        return new RoverArea(0, 0, maxX, maxY);
    }

}
