package p1615;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1615ATests extends AbstractOjTests {
    public CF1615ATests() {
        super("/p1615/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1615A.main(null);
        super.doAssertion();
    }
}
