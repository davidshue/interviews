package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by david on 3/8/17.
 */
public class DisjointUnionSetsTest {
    @Test
    public void find() throws Exception {
        int n = 5;
        DisjointUnionSets dus = new DisjointUnionSets(n);

        // 0 is edges friend of 2
        dus.union(0, 2);

        // 4 is edges friend of 2
        dus.union(4, 2);

        // 3 is edges friend of 1
        dus.union(3, 1);

        assertEquals(dus.find(4), dus.find(0));
        assertNotEquals(dus.find(1), dus.find(0));
    }

    @Test
    public void testAscii() {
        int i9 = '9' - '0';
        int i8 = '8' - '0';

        System.out.println(i9);
        System.out.println(i8);
    }
}