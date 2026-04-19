package p2117;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2117DTests extends AbstractOjTests {
    public CF2117DTests() {
        super("/p2117/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2117D.main(null);
        super.doAssertion(OUTPUT1);
    }
}