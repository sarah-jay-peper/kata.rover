package de.c_peper.kata.rover;

abstract class Direction {

    static Direction init() {
        return new North();
    }

    public abstract Boolean forwards(RoverPosition position);

    public abstract Boolean backwards(RoverPosition position);

    public abstract Direction turnRight();

    public abstract Direction turnLeft();

    public abstract String toString();

    private static class North extends Direction {

        @Override
        public Boolean forwards(RoverPosition position) {
            return position.moveNorth();
        }

        @Override
        public Boolean backwards(RoverPosition position) {
            return position.moveSouth();
        }

        @Override
        public Direction turnRight() {
            return new East();
        }

        @Override
        public Direction turnLeft() {
            return new West();
        }

        @Override
        public String toString() {
            return "N";
        }
    }

    private static class East extends Direction {

        @Override
        public Boolean forwards(RoverPosition position) {
            return position.moveEast();
        }

        @Override
        public Boolean backwards(RoverPosition position) {
            return position.moveWest();
        }

        @Override
        public Direction turnRight() {
            return new South();
        }

        @Override
        public Direction turnLeft() {
            return new North();
        }

        @Override
        public String toString() {
            return "E";
        }
    }

    private static class South extends Direction {

        @Override
        public Boolean forwards(RoverPosition position) {
            return position.moveSouth();
        }

        @Override
        public Boolean backwards(RoverPosition position) {
            return position.moveNorth();
        }

        @Override
        public Direction turnRight() {
            return new West();
        }

        @Override
        public Direction turnLeft() {
            return new East();
        }

        @Override
        public String toString() {
            return "S";
        }
    }

    private static class West extends Direction {

        @Override
        public Boolean forwards(RoverPosition position) {
            return position.moveWest();
        }

        @Override
        public Boolean backwards(RoverPosition position) {
            return position.moveEast();
        }

        @Override
        public Direction turnRight() {
            return new North();
        }

        @Override
        public Direction turnLeft() {
            return new South();
        }

        @Override
        public String toString() {
            return "W";
        }
    }
}