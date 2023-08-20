package p547;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF547BTests extends AbstractOjTests {
    public CF547BTests() {
        super("/p547/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF547B.main(null);
        super.doAssertion();
    }
}