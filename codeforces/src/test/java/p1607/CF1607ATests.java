package p1607;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1607ATests extends AbstractOjTests {
    public CF1607ATests() {
        super("p1607/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1607A.main(null);
        super.doAssertion();
    }
}
