package p1834;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1834ATests extends AbstractOjTests {
    public CF1834ATests() {
        super("/p1834/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1834A.main(null);
        super.doAssertion();
    }
}