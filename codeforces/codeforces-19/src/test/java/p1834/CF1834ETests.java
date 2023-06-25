package p1834;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1834ETests extends AbstractOjTests {
    public CF1834ETests() {
        super("/p1834/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1834E.main(null);
        super.doAssertion();
    }
}