package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

// 4/4
public class DD2019012Tests extends AbstractOjTests {
    public DD2019012Tests() {
        super("/didi/2019012/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DD2019012.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        DD2019012.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        DD2019012.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        DD2019012.main(null);
        super.doAssertion(OUTPUT4);
    }
}
