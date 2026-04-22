package p2117;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2117FTests extends AbstractOjTests {
    public CF2117FTests() {
        super("/p2117/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2117F.main(null);
        super.doAssertion(OUTPUT1);
    }
}