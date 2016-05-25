package matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by f on 23.05.16.
 *
 */
public class CalculateArrayTest {

    @Test
    public void testCalculate() throws Exception {
        String[][] arrStr = StreamParser.parse(TestInputStream.get());
        new CalculateArray(arrStr).calculate();
        assertEquals("16.0", arrStr[0][3]);
    }
}