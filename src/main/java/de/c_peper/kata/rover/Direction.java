package de.c_peper.kata.rover;

import lombok.Builder;

import java.util.function.Supplier;

@Builder
class Direction {

    private final static Direction NORTH = Direction.builder()
        .id("N")
        .forward(Movement.NORTH)
        .backward(Movement.SOUTH)
        .right(() -> Direction.EAST)
        .left(() -> Direction.WEST)
        .build();
    private final static Direction EAST = Direction.builder()
        .id("E")
        .forward(Movement.EAST)
        .backward(Movement.WEST)
        .right(() -> Direction.SOUTH)
        .left(() -> Direction.NORTH)
        .build();
    private final static Direction SOUTH = Direction.builder()
        .id("S")
        .forward(Movement.SOUTH)
        .backward(Movement.NORTH)
        .right(() -> Direction.WEST)
        .left(() -> Direction.EAST)
        .build();
    private final static Direction WEST = Direction.builder()
        .id("W")
        .forward(Movement.WEST)
        .backward(Movement.EAST)
        .right(() -> Direction.NORTH)
        .left(() -> Direction.SOUTH)
        .build();

    private final Movement forward;
    private final Movement backward;
    private final Supplier<Direction> left;
    private final Supplier<Direction> right;
    private final String id;

    static Direction init() { return NORTH; }

    Boolean forwards(RoverPosition position) { return position.move(forward); }

    Boolean backwards(RoverPosition position) { return position.move(backward); }

    Direction turnRight() { return right.get(); }

    Direction turnLeft() { return left.get(); }

    @Override
    public String toString() {
        return id;
    }
}