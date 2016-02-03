import de.c_peper.kata.rover.Rover;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by trublu on 03/02/16.
 */
public class RoverTest {

    @Test
    public void testName() throws Exception {

        Rover rover = new Rover();

        Assert.assertTrue(Rover.getPositionString() == "0,0,N");
    }
}
