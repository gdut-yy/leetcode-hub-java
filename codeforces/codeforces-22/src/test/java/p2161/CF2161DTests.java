package p2161;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2161DTests extends AbstractOjTests {
    public CF2161DTests() {
        super("/p2161/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2161D.main(null);
        super.doAssertion(OUTPUT1);
    }
}