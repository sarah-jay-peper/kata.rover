package de.c_peper.kata.rover;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoverPosition {

    private RoverArea field;

    private Integer x;

    private Integer y;

    public void setNewPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    private void setY(Integer y) {
        this.y = y;
    }

    private void setX(Integer x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Boolean moveNorth(Integer obstaclePosY) {
        Integer newY = getY() + 1;
        if (newY.equals(field.getMaxY())) {
            newY = field.getMinY();
        }
        if (newY.equals(obstaclePosY)) {
            return Boolean.FALSE;
        } else {
            setY(newY);
        }
        return Boolean.TRUE;
    }

    public Boolean moveWest(Integer obstaclePosX) {
        Integer newX = getX() - 1;
        if (newX < field.getMinX()) {
            newX = field.getMaxX() - 1;
        }
        if (newX.equals(obstaclePosX)) {
            return Boolean.FALSE;
        }
        setX(newX);
        return Boolean.TRUE;
    }

    public Boolean moveEast(Integer obstaclePosX) {
        Integer newX = getX() + 1;
        if (newX.equals(field.getMaxX())) {
            newX = field.getMinX();
        }
        if (newX.equals(obstaclePosX)) {
            return Boolean.FALSE;
        }
        setX(newX);
        return Boolean.TRUE;
    }

    public Boolean moveSouth(Integer obstaclePosY) {
        Integer newY = getY() -1;
        if (newY < field.getMinY()) {
            newY = field.getMaxY() - 1;
        }
        if (newY.equals(obstaclePosY)) {
            return Boolean.FALSE;
        }
        setY(newY);
        return Boolean.TRUE;
    }
}
