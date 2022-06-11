package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690ATests extends AbstractOjTests {
    public CF1690ATests() {
        super("/p1690/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690A.main(null);
        super.doAssertion();
    }
}
