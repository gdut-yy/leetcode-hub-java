package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

// 5/10
public class DD2020007Tests extends AbstractOjTests {
    public DD2020007Tests() {
        super("/didi/2020007/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DD2020007.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        DD2020007.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        DD2020007.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        DD2020007.main(null);
        super.doAssertion(OUTPUT4);
    }

    @Test
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
        DD2020007.main(null);
        super.doAssertion(OUTPUT5);
    }
}
