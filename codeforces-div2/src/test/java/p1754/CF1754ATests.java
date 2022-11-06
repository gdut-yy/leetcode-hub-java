package p1754;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1754ATests extends AbstractOjTests {
    public CF1754ATests() {
        super("/p1754/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1754A.main(null);
        super.doAssertion();
    }
}
