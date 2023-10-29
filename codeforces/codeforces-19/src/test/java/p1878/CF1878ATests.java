package p1878;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1878ATests extends AbstractOjTests {
    public CF1878ATests() {
        super("/p1878/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1878A.main(null);
        super.doAssertion();
    }
}