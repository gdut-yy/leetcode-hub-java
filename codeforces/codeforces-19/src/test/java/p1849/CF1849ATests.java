package p1849;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1849ATests extends AbstractOjTests {
    public CF1849ATests() {
        super("/p1849/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1849A.main(null);
        super.doAssertion();
    }
}