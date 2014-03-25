package org.barlas.complex.parser;

import ORG.netlib.math.complex.Complex;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ParserTest {

    @Test
    public void testSimpleParse() throws ParseException {
        parse("return 0;");
    }

    @Test(expected = ParseException.class)
    public void testInputNoTrailingSemicolon() throws ParseException {
        parse("return 0");
    }

    @Test
    public void testSimpleParseAndEvaluate() throws ParseException {
        verifyEquals("return 0;", new Complex(0));
    }

    @Test
    public void testAdd() throws ParseException {
        verifyEquals("return 1 + 2;", new Complex(3));
    }

    @Test
    public void testAddSubtract() throws ParseException {
        verifyEquals("return 1 + 2, 5 - 2i;", new Complex(3), new Complex(5, -2));
    }

    @Test
    public void testMod() throws ParseException {
        verifyEquals("return 100 % 10, 10 % 3;", new Complex(0), new Complex(1));
    }

    @Test
    public void testAbs() throws ParseException {
        verifyEquals("return |-3|, |3 + 4i|;", new Complex(3), new Complex(5));
    }

    @Test
    public void testAnd() throws ParseException {
        verifyEquals("return 0 < 1;", new Complex(1));
    }

    @Test
    public void testAssignment() throws ParseException {
        verifyEquals("a = 1; return a;", new Complex(1));
    }

    @Test
    public void testFor() throws ParseException {
        // 0, 1, 1, 2, 3, 5, 8
        verifyEquals("prev = 0; cur = 1; for(n in 1..5) { tmp = cur; cur = prev + cur; prev = tmp; } return cur;", new Complex(8));
    }

    @Test
    public void testComparisons() throws ParseException {
        verifyEquals("return 0 < 1, 0 <= 0, 1 >= 1, 2 > 1, 1 == 1, 1 != 2;", new Complex(1.0), new Complex(1.0), new Complex(1.0), new Complex(1.0), new Complex(1.0), new Complex(1.0));
    }

    @Test
    public void testIfStatement() throws ParseException {
        verifyEquals("a = 0; if(a > 1) return 0; return 1;", new Complex(1.0));
    }

    @Test
    public void testLog() throws ParseException {
        verifyEquals("return log(8);", new Complex(Math.log(8)));
    }

    @Test
    public void testMultiply() throws ParseException {
        verifyEquals("return 3 * 4;", new Complex(12.0));
    }

    @Test
    public void testNegate() throws ParseException {
        verifyEquals("return -(3 * 4);", new Complex(-12.0));
    }

    @Test
    public void testFibonacciBenchmark() throws ParseException {
        Statement stmt = parse("prev = 0; cur = 1; for(n in 1..25) { tmp = cur; cur = prev + cur; prev = tmp; } return cur;");

        for(int i=0; i<5; i++) {
            long time = System.currentTimeMillis();
            for(int j=0; j<10000; j++) {
                try {
                    stmt.evaluate(new Context());
                } catch(ReturnException ignore) {}
            }
            long elapsed = System.currentTimeMillis() - time;
            System.out.println("[fibonacci benchmark] " + elapsed);
        }
    }

    private void verifyEquals(String input, Complex ... expected) throws ParseException {
        Complex[] result = evaluate(input);
        Assert.assertNotNull(result);
        Assert.assertEquals(expected.length, result.length);
        for(int i=0; i<expected.length; i++) {
            Assert.assertEquals("real component unequal", expected[i].re(), result[i].re(), 0.0);
            Assert.assertEquals("imaginary component unequal", expected[i].im(), result[i].im(), 0.0);
        }
    }

    private Statement parse(String input) throws ParseException {
        return new Parser(new ByteArrayInputStream(input.getBytes())).Root();
    }

    private Complex[] evaluate(String input) throws ParseException {
        try {
            parse(input).evaluate(new Context());
            return null;
        } catch(ReturnException e) {
            return e.getValues();
        }
    }

}
