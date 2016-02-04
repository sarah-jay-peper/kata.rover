import de.c_peper.kata.rover.Rover;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

    @Test
    public void testGetInitialPosition() throws Exception {
        Rover rover = new Rover();
        assertEquals(("0,0,N"), rover.getPositionString());
    }

    @Test
    public void testTurnRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');

        assertEquals(rover.getPositionString(), ("0,0,E"));
    }

    @Test
    public void testTurnRightRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');
        rover.processInput('R');

        assertEquals(rover.getPositionString(), ("0,0,S"));
    }

    @Test
    public void testTurnRightRightRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');
        rover.processInput('R');
        rover.processInput('R');

        assertEquals(rover.getPositionString(), ("0,0,W"));
    }

    @Test
    public void testTurnRightRightRightRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');
        rover.processInput('R');
        rover.processInput('R');
        rover.processInput('R');

        assertEquals(rover.getPositionString(), ("0,0,N"));
    }

    @Test
    public void testTurnLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');

        assertEquals(rover.getPositionString(), ("0,0,W"));
    }

    @Test
    public void testTurnLeftLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');
        rover.processInput('L');

        assertEquals(rover.getPositionString(), ("0,0,S"));
    }

    @Test
    public void testTurnLeftLeftLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');
        rover.processInput('L');
        rover.processInput('L');

        assertEquals(rover.getPositionString(), ("0,0,E"));
    }

    @Test
    public void testTurnLeftLeftLeftLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');
        rover.processInput('L');
        rover.processInput('L');
        rover.processInput('L');

        assertEquals(rover.getPositionString(), ("0,0,N"));
    }

    @Test
    public void testTurnRightRightRightAsString() throws Exception {
        Rover rover = new Rover();

        rover.processInput("RRR");

        assertEquals(rover.getPositionString(), ("0,0,W"));
    }

    @Test
    public void testMoveForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput('F');

        assertEquals(rover.getPositionString(), ("0,1,N"));
    }

    @Test
    public void testMoveBackward() throws Exception {
        Rover rover = new Rover();

        rover.processInput('B');

        assertEquals(rover.getPositionString(), ("0,9,N"));
    }

    @Test
    public void testMoveForwardThanBackward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("FB");

        assertEquals(rover.getPositionString(), ("0,0,N"));
    }

    @Test
    public void testMoveBackwardThanForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("BF");

        assertEquals(rover.getPositionString(), ("0,0,N"));
    }

    @Test
    public void testTurnRightThanMoveForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("RF");

        assertEquals(rover.getPositionString(), "1,0,E");
    }

    @Test
    public void testTurnRightRightThanMoveForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("RRF");

        assertEquals("0,9,S", rover.getPositionString());
    }

    @Test
    public void testTurnRightRightThanMoveTwiceForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("RRFF");

        assertEquals("0,8,S", rover.getPositionString());
    }
}
