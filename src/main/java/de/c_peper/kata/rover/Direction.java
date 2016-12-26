package de.c_peper.kata.rover;

import lombok.Builder;

import java.util.function.Function;
import java.util.function.Supplier;

@Builder
class Direction {

    private static Direction NORTH = Direction.builder()
            .id("N")
            .forward(RoverPosition::moveNorth)
            .backward(RoverPosition::moveSouth)
            .right(() -> Direction.EAST)
            .left(() -> Direction.WEST)
            .build();
    private static Direction EAST = Direction.builder()
            .id("E")
            .forward(RoverPosition::moveEast)
            .backward(RoverPosition::moveWest)
            .right(() -> Direction.SOUTH)
            .left(() -> Direction.NORTH)
            .build();
    private static Direction SOUTH = Direction.builder()
            .id("S")
            .forward(RoverPosition::moveSouth)
            .backward(RoverPosition::moveNorth)
            .right(() -> Direction.WEST)
            .left(() -> Direction.EAST)
            .build();
    private static Direction WEST = Direction.builder()
            .id("W")
            .forward(RoverPosition::moveWest)
            .backward(RoverPosition::moveEast)
            .right(() -> Direction.NORTH)
            .left(() -> Direction.SOUTH)
            .build();
    private Function<RoverPosition, Boolean> forward;

    private Function<RoverPosition, Boolean> backward;

    private Supplier<Direction> left;

    private Supplier<Direction> right;

    private String id;

    static Direction init() { return NORTH; }

    Boolean forwards(RoverPosition position) { return forward.apply(position); }

    Boolean backwards(RoverPosition position) { return backward.apply(position); }

    Direction turnRight() { return right.get(); }

    Direction turnLeft() { return left.get(); }

    @Override
    public String toString() { return id; }
}