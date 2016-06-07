package de.c_peper.kata.rover;

import lombok.Getter;

@Getter
class RoverPosition extends Position {

    private RoverArea field;

    RoverPosition(RoverArea field, Integer posX, Integer posY) {
        super(posX, posY);
        this.field = field;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    Boolean moveNorth() {
        Integer newY = field.increaseY(getY());
        if (field.hasObstacle(getX(), newY)) return Boolean.FALSE;
        setY(newY);
        return Boolean.TRUE;
    }

    Boolean moveWest() {
        Integer newX = field.decreaseX(getX());
        if (field.hasObstacle(newX, getY())) return Boolean.FALSE;
        setX(newX);
        return Boolean.TRUE;
    }

    Boolean moveEast() {
        Integer newX = field.increaseX(getX());
        if (field.hasObstacle(newX, getY())) return Boolean.FALSE;
        setX(newX);
        return Boolean.TRUE;
    }

    Boolean moveSouth() {
        Integer newY = field.decreaseY(getY());
        if (field.hasObstacle(getX(), newY)) return Boolean.FALSE;
        setY(newY);
        return Boolean.TRUE;
    }
}
