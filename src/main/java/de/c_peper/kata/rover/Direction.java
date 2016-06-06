package de.c_peper.kata.rover;

import lombok.Builder;

import java.util.function.Function;
import java.util.function.Supplier;

@Builder
class Direction {

    Function<RoverPosition, Boolean> forward;

    Function<RoverPosition, Boolean> backward;

    Supplier<Direction> left;

    Supplier<Direction> right;

    String id;

    static Direction init() {
        return north();
    }

    private static Direction north() {
        return Direction.builder()
                .id("N")
                .forward(RoverPosition::moveNorth)
                .backward(RoverPosition::moveSouth)
                .right(Direction::east)
                .left(Direction::west)
                .build();
    }

    private static Direction east() {
        return Direction.builder()
                .id("E")
                .forward(RoverPosition::moveEast)
                .backward(RoverPosition::moveWest)
                .right(Direction::south)
                .left(Direction::north)
                .build();
    }

    private static Direction south() {
        return Direction.builder()
                .id("S")
                .forward(RoverPosition::moveSouth)
                .backward(RoverPosition::moveNorth)
                .right(Direction::west)
                .left(Direction::east)
                .build();
    }

    private static Direction west() {
        return Direction.builder()
                .id("W")
                .forward(RoverPosition::moveWest)
                .backward(RoverPosition::moveEast)
                .right(Direction::north)
                .left(Direction::south)
                .build();
    }

    Boolean forwards(RoverPosition position) { return forward.apply(position); }

    Boolean backwards(RoverPosition position) { return backward.apply(position); }

    Direction turnRight() { return right.get(); }

    Direction turnLeft() { return left.get(); }

    @Override
    public String toString() { return id; }
}