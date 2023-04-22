package p1473;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1473DTests extends AbstractOjTests {
    public CF1473DTests() {
        super("/p1473/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1473D.main(null);
        super.doAssertion();
    }
}