package p1627;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1627ATests extends AbstractOjTests {
    public CF1627ATests() {
        super("/p1627/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1627A.main(null);
        super.doAssertion();
    }
}
