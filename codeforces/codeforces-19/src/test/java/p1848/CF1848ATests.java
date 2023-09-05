package p1848;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1848ATests extends AbstractOjTests {
    public CF1848ATests() {
        super("/p1848/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1848A.main(null);
        super.doAssertion();
    }
}