package p1593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1593ATests extends AbstractOjTests {
    public CF1593ATests() {
        super("/p1593/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1593A.main(null);
        super.doAssertion();
    }
}
