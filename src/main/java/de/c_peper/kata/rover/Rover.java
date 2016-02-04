package de.c_peper.kata.rover;

import lombok.Data;

/**
 * X = 0..9 W <-> E
 * Y = 0..9 S <-> N
 * direction = N,E,S,W
 * R: N->E->S->W->N
 * L: N->W->S->E->N
 */
@Data
public class Rover {

    public static final int MAX_Y = 10;

    public static final int MAX_X = 10;

    private Integer x;

    private Integer y;

    private Direction direction;

    public Rover() {
        x = 0;
        y = 0;
        direction = Direction.N;
    }

    public String getPositionString() {
        return x + "," + y + "," + direction.toString();
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
                switch (direction) {
                    case N:
                        y++;
                        if (y == MAX_Y) {
                            y = 0;
                        }
                        break;
                    case E:
                        x++;
                        if (x == MAX_X) {
                            x = 0;
                        }
                        break;
                    case S:
                        moveSouth();
                }
                break;
            case 'B':
                switch (direction) {
                    case N:
                        moveSouth();
                        break;
                    case E:
                        x--;
                        if (x < 0) {
                            x = MAX_X - 1;
                        }
                }
        }
    }

    private void moveSouth() {
        y--;
        if (y < 0) {
            y = MAX_Y - 1;
        }
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
        for (char inputChar : inputString.toCharArray()) {
            processInput(inputChar);
        }
    }
}
