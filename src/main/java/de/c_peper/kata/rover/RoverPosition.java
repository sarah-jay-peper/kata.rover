package de.c_peper.kata.rover;

import lombok.Getter;

@Getter
public class RoverPosition extends Position {

    private RoverArea field;

    public RoverPosition(RoverArea field, Integer posX, Integer posY) {
        super(posX, posY);
        this.field = field;
    }

    public void setNewPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Boolean moveNorth(Position obstacle) {
        Integer newY = getY() + 1;
        if (newY.equals(field.getMaxY())) {
            newY = field.getMinY();
        }
        if (obstacle.equals(getX(), newY)) {
            return Boolean.FALSE;
        } else {
            setY(newY);
        }
        return Boolean.TRUE;
    }

    public Boolean moveWest(Position obstacle) {
        Integer newX = getX() - 1;
        if (newX < field.getMinX()) {
            newX = field.getMaxX() - 1;
        }
        if (obstacle.equals(newX, getY())) {
            return Boolean.FALSE;
        }
        setX(newX);
        return Boolean.TRUE;
    }

    public Boolean moveEast(Position obstacle) {
        Integer newX = getX() + 1;
        if (newX.equals(field.getMaxX())) {
            newX = field.getMinX();
        }
        if (obstacle.equals(newX, getY())) {
            return Boolean.FALSE;
        }
        setX(newX);
        return Boolean.TRUE;
    }

    public Boolean moveSouth(Position obstacle) {
        Integer newY = getY() -1;
        if (newY < field.getMinY()) {
            newY = field.getMaxY() - 1;
        }
        if (obstacle.equals(getX(), newY)) {
            return Boolean.FALSE;
        }
        setY(newY);
        return Boolean.TRUE;
    }
}
