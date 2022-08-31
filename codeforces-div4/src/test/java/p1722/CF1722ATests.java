package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722ATests extends AbstractOjTests {
    public CF1722ATests() {
        super("/p1722/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722A.main(null);
        super.doAssertion();
    }
}
