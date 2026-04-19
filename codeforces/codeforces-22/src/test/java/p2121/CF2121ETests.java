package p2121;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2121ETests extends AbstractOjTests {
    public CF2121ETests() {
        super("/p2121/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2121E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
