package p2014;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2014DTests extends AbstractOjTests {
    public CF2014DTests() {
        super("/p2014/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2014D.main(null);
        super.doAssertion(OUTPUT1);
    }
}