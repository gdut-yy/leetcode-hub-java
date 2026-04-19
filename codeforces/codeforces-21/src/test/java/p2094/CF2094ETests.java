package p2094;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2094ETests extends AbstractOjTests {
    public CF2094ETests() {
        super("/p2094/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2094E.main(null);
        super.doAssertion(OUTPUT1);
    }
}