package de.c_peper.kata.rover;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class RoverArea {
    private final Axis axisX;
    private final Axis axisY;
    private final List<Position> obstacles = new ArrayList<>();

    private RoverArea(Integer minX, Integer minY, Integer maxX, Integer maxY) {
        axisX = new Axis(minX, maxX);
        axisY = new Axis(minY, maxY);
    }

    static RoverArea getDefaultField() {
        return new RoverArea(0, 0, 9, 9);
    }

    public static RoverArea getZeroBasedFieldExclusiveUpperLimit(Integer maxX, Integer maxY) {
        return new RoverArea(0, 0, maxX-1, maxY-1);
    }

    public static RoverArea getField(Integer minX, Integer minY, Integer maxX, Integer maxY) {
        return new RoverArea(minX, minY, maxX, maxY);
    }

    void addObstacle(Position obstacle) {
        obstacles.add(obstacle);
    }

    Boolean hasObstacle(Integer x, Integer y) {
        return hasObstacle(new Position(x, y));
    }

    private Boolean hasObstacle(Position position) {
        for (Position obstacle : obstacles) {
            if (obstacle.equals(position)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    Integer increaseY(Integer y) {
        return axisY.increase(y);
    }

    Integer decreaseY(Integer y) {
        return axisY.decrease(y);
    }

    Integer increaseX(Integer x) {
        return axisX.increase(x);
    }

    Integer decreaseX(Integer x) {
        return axisX.decrease(x);
    }
}

@RequiredArgsConstructor
class Axis {
    private final Integer min;
    private final Integer max;

    Integer increase(Integer input) { return input + 1 > max ? min : input + 1; }

    Integer decrease(Integer input) { return input - 1 < min ? max : input - 1; }
}