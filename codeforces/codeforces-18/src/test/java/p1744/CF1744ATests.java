package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744ATests extends AbstractOjTests {
    public CF1744ATests() {
        super("/p1744/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1744A.main(null);
        super.doAssertion();
    }
}
