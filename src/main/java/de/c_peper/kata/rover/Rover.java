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

    public Rover() {
        this(RoverArea.getDefaultField());
    }

    public Rover(RoverArea field) {
        position = new RoverPosition(field, 0, 0);
        direction = Direction.init();
    }

    public String getPositionString() {
        return position.toString() + "," + direction.toString();
    }

    public void processInput(char input) {
        handleSingleInput(input);
    }

    private Boolean handleSingleInput(char input) {
        switch (input) {
            case 'R':
                direction = direction.turnRight();
                return Boolean.TRUE;
            case 'L':
                direction = direction.turnLeft();
                return Boolean.TRUE;
            case 'F':
                return direction.forwards(position);
            case 'B':
                return direction.backwards(position);
            default:
                return Boolean.FALSE;
        }
    }

    public void processInput(String inputString) {
        for (char inputChar : inputString.toCharArray()) {
            Boolean continueMovement = handleSingleInput(inputChar);
            if (!continueMovement) {
                break;
            }
        }
    }

    public void addObstacle(Integer positionX, Integer positionY) {
        position.getField().addObstacle(new Position(positionX, positionY));
    }
}