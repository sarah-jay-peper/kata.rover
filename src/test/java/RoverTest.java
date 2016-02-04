import de.c_peper.kata.rover.Rover;
import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void testGetInitialPosition() throws Exception {
        Rover rover = new Rover();
        Assert.assertTrue(rover.getPositionString().equals("0,0,N"));
    }

    @Test
    public void testTurnRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');

        Assert.assertTrue(rover.getPositionString().equals("0,0,E"));
    }

    @Test
    public void testTurnRightRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');
        rover.processInput('R');

        Assert.assertTrue(rover.getPositionString().equals("0,0,S"));
    }

    @Test
    public void testTurnRightRightRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');
        rover.processInput('R');
        rover.processInput('R');

        Assert.assertTrue(rover.getPositionString().equals("0,0,W"));
    }

    @Test
    public void testTurnRightRightRightRight() throws Exception {
        Rover rover = new Rover();

        rover.processInput('R');
        rover.processInput('R');
        rover.processInput('R');
        rover.processInput('R');

        Assert.assertTrue(rover.getPositionString().equals("0,0,N"));
    }

    @Test
    public void testTurnLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');

        Assert.assertTrue(rover.getPositionString().equals("0,0,W"));
    }

    @Test
    public void testTurnLeftLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');
        rover.processInput('L');

        Assert.assertTrue(rover.getPositionString().equals("0,0,S"));
    }

    @Test
    public void testTurnLeftLeftLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');
        rover.processInput('L');
        rover.processInput('L');

        Assert.assertTrue(rover.getPositionString().equals("0,0,E"));
    }

    @Test
    public void testTurnLeftLeftLeftLeft() throws Exception {
        Rover rover = new Rover();

        rover.processInput('L');
        rover.processInput('L');
        rover.processInput('L');
        rover.processInput('L');

        Assert.assertTrue(rover.getPositionString().equals("0,0,N"));
    }

    @Test
    public void testTurnRightRightRightAsString() throws Exception {
        Rover rover = new Rover();

        rover.processInput("RRR");

        Assert.assertTrue(rover.getPositionString().equals("0,0,W"));
    }

    @Test
    public void testMoveForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput('F');

        Assert.assertTrue(rover.getPositionString().equals("1,0,N"));
    }

    @Test
    public void testMoveBackward() throws Exception {
        Rover rover = new Rover();

        rover.processInput('B');

        Assert.assertTrue(rover.getPositionString().equals("9,0,N"));
    }

    @Test
    public void testMoveForwardThanBackward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("FB");

        Assert.assertTrue(rover.getPositionString().equals("0,0,N"));
    }

    @Test
    public void testMoveBackwardThanForward() throws Exception {
        Rover rover = new Rover();

        rover.processInput("BF");

        Assert.assertTrue(rover.getPositionString().equals("0,0,N"));
    }
}
