package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DD2020011Tests extends AbstractOjTests {
    public DD2020011Tests() {
        super("/didi/2020011/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DD2020011.main(null);
        super.doAssertion(OUTPUT1);
    }
}
