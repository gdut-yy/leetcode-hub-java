package p2061;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2061DTests extends AbstractOjTests {
    public CF2061DTests() {
        super("/p2061/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2061D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
