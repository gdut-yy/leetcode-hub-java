package p2008;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2008ETests extends AbstractOjTests {
    public CF2008ETests() {
        super("/p2008/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2008E.main(null);
        super.doAssertion(OUTPUT1);
    }
}