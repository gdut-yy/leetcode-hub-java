package p915;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF915FTests extends AbstractOjTests {
    public CF915FTests() {
        super("/p915/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF915F.main(null);
        super.doAssertion();
    }
}