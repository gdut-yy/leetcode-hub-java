package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669ATests extends AbstractOjTests {
    public CF1669ATests() {
        super("/p1669/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669A.main(null);
        super.doAssertion();
    }
}
