package p1841;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1841ATests extends AbstractOjTests {
    public CF1841ATests() {
        super("/p1841/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1841A.main(null);
        super.doAssertion();
    }
}