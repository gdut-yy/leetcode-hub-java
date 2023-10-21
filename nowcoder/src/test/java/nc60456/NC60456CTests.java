package nc60456;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC60456CTests extends AbstractOjTests {
    public NC60456CTests() {
        super("/nc60456/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC60456C.main(null);
        super.doAssertion(OUTPUT1);
    }
}