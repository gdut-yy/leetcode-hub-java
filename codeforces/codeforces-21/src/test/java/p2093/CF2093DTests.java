package p2093;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2093DTests extends AbstractOjTests {
    public CF2093DTests() {
        super("/p2093/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2093D.main(null);
        super.doAssertion(OUTPUT1);
    }
}