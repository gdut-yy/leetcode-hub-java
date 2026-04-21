package p817;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF817ETests extends AbstractOjTests {
    public CF817ETests() {
        super("/p817/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF817E.main(null);
        super.doAssertion(OUTPUT1);
    }
}