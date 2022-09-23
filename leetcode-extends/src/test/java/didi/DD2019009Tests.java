package didi;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

// 1/10
public class DD2019009Tests extends AbstractOjTests {
    public DD2019009Tests() {
        super("/didi/2019009/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DD2019009.main(null);
        super.doAssertion(OUTPUT1);
    }
}
