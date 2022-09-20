package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DD2019004Tests extends AbstractOjTests {
    public DD2019004Tests() {
        super("/didi/2019004/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DD2019004.main(null);
        super.doAssertion(OUTPUT1);
    }
}
