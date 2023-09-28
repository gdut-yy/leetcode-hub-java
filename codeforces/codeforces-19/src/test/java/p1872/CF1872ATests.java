package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872ATests extends AbstractOjTests {
    public CF1872ATests() {
        super("/p1872/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872A.main(null);
        super.doAssertion();
    }
}