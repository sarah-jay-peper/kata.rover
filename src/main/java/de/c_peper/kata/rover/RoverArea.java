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

    Integer validateY(Integer y) {
        return axisY.validate(y);
    }

    Integer validateX(Integer x) {
        return axisX.validate(x);
    }
}

@RequiredArgsConstructor
class Axis {
    private final Integer min;
    private final Integer max;

    Integer validate(Integer input) {
        if (input > max) {
            return min;
        }
        if (input < min) {
            return max;
        }
        return input;
    }
}