package p2117;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2117GTests extends AbstractOjTests {
    public CF2117GTests() {
        super("/p2117/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2117G.main(null);
        super.doAssertion(OUTPUT1);
    }
}