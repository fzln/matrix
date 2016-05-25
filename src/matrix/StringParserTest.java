package matrix;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by f on 19.05.16.
 *
 */
public class StringParserTest {

    @Test
    public void testParseSimple() throws Exception {
        String str = StringParser.parse("1");
        assertEquals("1.0", str);
    }

    @Test
    public void testParseAdd() throws Exception {
        String str = StringParser.parse("1 2 +");
        assertEquals("3.0", str);
    }

    @Test
    public void testParseSub() throws Exception {
        String str = StringParser.parse("5 2 -");
        assertEquals("3.0", str);
    }

    @Test
    public void testParseMul() throws Exception {
        String str = StringParser.parse("3 2 *");
        assertEquals("6.0", str);
    }

    @Test
    public void testParseDiv() throws Exception {
        String str = StringParser.parse("7 2 /");
        assertEquals("3.5", str);
    }

    @Test
    public void testParseInc() throws Exception {
        String str = StringParser.parse("7 ++");
        assertEquals("8.0", str);
    }

    @Test
    public void testParseDec() throws Exception {
        String str = StringParser.parse("7 --");
        assertEquals("6.0", str);
    }

    @Test
    public void testParseComplex() throws Exception {
        String str = StringParser.parse("4 7 3 - + ++ 3 / 2 * --");
        assertEquals("5.0", str);
    }
}