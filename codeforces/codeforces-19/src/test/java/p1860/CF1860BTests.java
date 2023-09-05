package p1860;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1860BTests extends AbstractOjTests {
    public CF1860BTests() {
        super("/p1860/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1860B.main(null);
        super.doAssertion();
    }
}