package p1361;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1361BTests extends AbstractOjTests {
    public CF1361BTests() {
        super("/p1361/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1361B.main(null);
        super.doAssertion();
    }
}