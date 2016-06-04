package de.c_peper.kata.rover;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class RoverArea {

    private final Integer minX;

    private final Integer minY;

    private final Integer maxX;

    private final Integer maxY;

    private List<Position> obstacles = new ArrayList<>();

    static RoverArea getDefaultField() {
        return new RoverArea(0, 0, 10, 10);
    }

    public static RoverArea getZeroBasedField(Integer maxX, Integer maxY) {
        return new RoverArea(0, 0, maxX, maxY);
    }

    void addObstacle(Position obstacle) {
        obstacles.add(obstacle);
    }

    Boolean hasObstacle(Integer x, Integer y) {
        return hasObstacle(new Position(x,y));
    }

    private Boolean hasObstacle(Position position) {
        for (Position obstacle : obstacles) {
            if (obstacle.equals(position)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
