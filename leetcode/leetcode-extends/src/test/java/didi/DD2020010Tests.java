package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

// 2/2
public class DD2020010Tests extends AbstractOjTests {
    public DD2020010Tests() {
        super("/didi/2020010/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DD2020010.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        DD2020010.main(null);
        super.doAssertion(OUTPUT2);
    }
}
