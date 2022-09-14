package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DD2019002Tests extends AbstractOjTests {
    public DD2019002Tests() {
        super("/didi/2019002/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        DD2019002.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        DD2019002.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        DD2019002.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        DD2019002.main(null);
        super.doAssertion(OUTPUT4);
    }

    @Test
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
        DD2019002.main(null);
        super.doAssertion(OUTPUT5);
    }

    @Test
    public void example6() throws IOException {
        super.doSetSystemInOut(INPUT6);
        DD2019002.main(null);
        super.doAssertion(OUTPUT6);
    }
}
