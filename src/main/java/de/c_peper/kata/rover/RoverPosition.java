package de.c_peper.kata.rover;

import lombok.Getter;

import static de.c_peper.kata.rover.Movement.EAST;
import static de.c_peper.kata.rover.Movement.NORTH;
import static de.c_peper.kata.rover.Movement.SOUTH;
import static de.c_peper.kata.rover.Movement.WEST;

@Getter
class RoverPosition extends Position {
    private final RoverArea field;

    RoverPosition(RoverArea field, Integer posX, Integer posY) {
        super(posX, posY);
        this.field = field;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Boolean move(Movement movement) {
        Integer newY = field.validateY(getY() + movement.y);
        Integer newX = field.validateX(getX() + movement.x);
        if (field.hasObstacle(newX, newY)) {
            return Boolean.FALSE;
        }
        setY(newY);
        setX(newX);
        return Boolean.TRUE;
    }

    public Boolean moveNorth() {
        return move(NORTH);
    }

    public Boolean moveWest() {
        return move(WEST);
    }

    public Boolean moveEast() {
        return move(EAST);
    }

    public Boolean moveSouth() {
        return move(SOUTH);
    }
}
