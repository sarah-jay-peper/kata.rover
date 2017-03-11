package de.c_peper.kata.rover;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * X = 0..9 W <-> E ( -> RoverArea)
 * Y = 0..9 S <-> N ( -> RoverArea)
 * direction = N,E,S,W ( -> Direction)
 * R: N->E->S->W->N
 * L: N->W->S->E->N
 */
public class Rover {
    private final RoverPosition position;
    private final InputActions inputAction;

    private Direction direction;

    public Rover() {
        this(RoverArea.getDefaultField());
    }

    private Rover(RoverArea field) {
        position = new RoverPosition(field, 0, 0);
        direction = Direction.init();
        inputAction = new InputActions();
    }

    public String getPositionString() { return position.toString() + "," + direction.toString(); }

    public Boolean move(int input) { return inputAction.act(input); }

    public void move(String inputString) {
        inputString.chars()
                .anyMatch((c) -> isNotSuccessful(move(c)));
    }

    public void addObstacle(Integer positionX, Integer positionY) {
        position.getField().addObstacle(new Position(positionX, positionY));
    }

    private Boolean turn(Direction newDirection) {
        direction = newDirection;
        return Boolean.TRUE;
    }

    private Boolean isNotSuccessful(Boolean successOfMovement) {
        return !successOfMovement;
    }

    private class InputActions {

        private final Map<Integer, Supplier<Boolean>> map = new HashMap<>();

        InputActions() {
            add('R', () -> turn(direction.turnRight()));
            add('L', () -> turn(direction.turnLeft()));
            add('F', () -> direction.forwards(position));
            add('B', () -> direction.backwards(position));
        }

        private void add(int input, Supplier<Boolean> supplier) {
            map.put(input, supplier);
        }

        private Boolean act(int input) {
            return map.get(input).get();
        }
    }
}