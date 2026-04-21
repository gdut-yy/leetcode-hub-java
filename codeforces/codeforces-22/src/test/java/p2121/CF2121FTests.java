package p2121;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2121FTests extends AbstractOjTests {
    public CF2121FTests() {
        super("/p2121/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2121F.main(null);
        super.doAssertion(OUTPUT1);
    }
}