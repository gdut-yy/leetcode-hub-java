package p1619;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1619ATests extends AbstractOjTests {
    public CF1619ATests() {
        super("p1619/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1619A.main(null);
        super.doAssertion();
    }
}
