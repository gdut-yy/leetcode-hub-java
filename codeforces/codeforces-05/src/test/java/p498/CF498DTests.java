package p498;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF498DTests extends AbstractOjTests {
    public CF498DTests() {
        super("/p498/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF498D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
