package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

// 6/10
public class DDBook26Tests extends AbstractOjTests {
    public DDBook26Tests() {
        super("/didi/book26/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
         DDBook26.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
         DDBook26.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
         DDBook26.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
         DDBook26.main(null);
        super.doAssertion(OUTPUT4);
    }

    @Test
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
         DDBook26.main(null);
        super.doAssertion(OUTPUT5);
    }

    @Test
    public void example6() throws IOException {
        super.doSetSystemInOut(INPUT6);
         DDBook26.main(null);
        super.doAssertion(OUTPUT6);
    }

    @Test
    @Disabled
    public void example7() throws IOException {
        super.doSetSystemInOut(INPUT7);
         DDBook26.main(null);
        super.doAssertion(OUTPUT7);
    }

    @Test
    @Disabled
    public void example8() throws IOException {
        super.doSetSystemInOut(INPUT8);
         DDBook26.main(null);
        super.doAssertion(OUTPUT8);
    }

    @Test
    @Disabled
    public void example9() throws IOException {
        super.doSetSystemInOut(INPUT9);
         DDBook26.main(null);
        super.doAssertion(OUTPUT9);
    }

    @Test
    @Disabled
    public void example10() throws IOException {
        super.doSetSystemInOut(INPUT10);
         DDBook26.main(null);
        super.doAssertion(OUTPUT10);
    }
}
