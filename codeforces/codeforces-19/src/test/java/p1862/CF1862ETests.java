package p1862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1862ETests extends AbstractOjTests {
    public CF1862ETests() {
        super("/p1862/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1862E.main(null);
        super.doAssertion();
    }
}