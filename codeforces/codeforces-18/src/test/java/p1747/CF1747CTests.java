package p1747;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1747CTests extends AbstractOjTests {
    public CF1747CTests() {
        super("/p1747/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1747C.main(null);
        super.doAssertion(OUTPUT1);
    }
}