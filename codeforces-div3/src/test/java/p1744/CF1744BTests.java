package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744BTests extends AbstractOjTests {
    public CF1744BTests() {
        super("/p1744/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1744B.main(null);
        super.doAssertion();
    }
}
