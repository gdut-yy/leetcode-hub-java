package p2117;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2117ETests extends AbstractOjTests {
    public CF2117ETests() {
        super("/p2117/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2117E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
