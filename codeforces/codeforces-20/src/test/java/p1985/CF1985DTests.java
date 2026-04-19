package p1985;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1985DTests extends AbstractOjTests {
    public CF1985DTests() {
        super("/p1985/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1985D.main(null);
        super.doAssertion(OUTPUT1);
    }
}