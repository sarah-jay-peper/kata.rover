package de.c_peper.kata.rover;

import lombok.Getter;

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
}
