import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by david on 3/4/17.
 */
public class SudokoValidatorTest {
    private List<Integer> validBoard = Arrays.asList(
            1,2,3,4,5,6,7,8,9,
            4,5,6,7,8,9,1,2,3,
            7,8,9,1,2,3,4,5,6,
            8,9,1,2,3,4,5,6,7,
            2,3,4,5,6,7,8,9,1,
            5,6,7,8,9,1,2,3,4,
            6,7,8,9,1,2,3,4,5,
            9,1,2,3,4,5,6,7,8,
            3,4,5,6,7,8,9,1,2
    );
    private SudokoValidator validator = new SudokoValidator();

    @Test
    public void isValid() throws Exception {
        assertTrue(validator.isValid(validBoard));
    }

}