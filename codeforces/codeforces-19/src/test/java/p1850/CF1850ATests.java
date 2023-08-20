package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850ATests extends AbstractOjTests {
    public CF1850ATests() {
        super("/p1850/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850A.main(null);
        super.doAssertion();
    }
}