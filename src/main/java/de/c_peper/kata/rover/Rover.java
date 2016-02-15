package de.c_peper.kata.rover;

/**
 * X = 0..9 W <-> E ( -> RoverArea)
 * Y = 0..9 S <-> N ( -> RoverArea)
 * direction = N,E,S,W ( -> Direction)
 * R: N->E->S->W->N
 * L: N->W->S->E->N
 */
public class Rover {

    private RoverPosition position;

    private Direction direction;

    private Boolean continueMovement;

    public Rover() {
        this(RoverArea.getDefaultField());
    }

    public Rover(RoverArea field) {
        position = new RoverPosition(field, 0, 0);
        direction = Direction.N;
    }

    public String getPositionString() {
        return position.toString() + "," + direction.toString();
    }

    public void processInput(char input) {
        switch (input) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'F':
                moveForward();
                break;
            case 'B':
                moveBackward();
        }
    }

    private void moveBackward() {
        switch (direction) {
            case N:
                moveSouth();
                break;
            case E:
                moveWest();
                break;
            case W:
                moveEast();
                break;
            case S:
                moveNorth();
        }
    }

    private void moveForward() {
        switch (direction) {
            case N:
                moveNorth();
                break;
            case E:
                moveEast();
                break;
            case S:
                moveSouth();
                break;
            case W:
                moveWest();
                break;
        }
    }

    private void moveNorth() {
        continueMovement = position.moveNorth();
    }

    private void moveWest() {
        continueMovement = position.moveWest();
    }

    private void moveEast() {
        continueMovement = position.moveEast();
    }

    private void moveSouth() {
        continueMovement = position.moveSouth();
    }

    private void turnRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.S;
                break;
            case S:
                direction = Direction.W;
                break;
            case W:
                direction = Direction.N;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case W:
                direction = Direction.S;
                break;
            case S:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.N;
        }
    }

    public void processInput(String inputString) {
        continueMovement = Boolean.TRUE;
        for (char inputChar : inputString.toCharArray()) {
            processInput(inputChar);
            if (!continueMovement) {
                break;
            }
        }
    }

    public void addObstacle(Integer positionX, Integer positionY) {
        position.getField().addObstacle(new Position(positionX, positionY));
    }
}
