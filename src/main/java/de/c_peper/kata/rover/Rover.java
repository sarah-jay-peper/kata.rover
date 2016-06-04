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
        direction = new North();
    }

    public String getPositionString() {
        return position.toString() + "," + direction.toString();
    }

    public void processInput(char input) {
        switch (input) {
            case 'R':
                direction = direction.turnRight();
                break;
            case 'L':
                direction = direction.turnLeft();
                break;
            case 'F':
                continueMovement = direction.forwards(position);
                break;
            case 'B':
                continueMovement = direction.backwards(position);
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