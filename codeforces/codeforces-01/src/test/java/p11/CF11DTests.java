package p11;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF11DTests extends AbstractOjTests {
    public CF11DTests() {
        super("/p11/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF11D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
