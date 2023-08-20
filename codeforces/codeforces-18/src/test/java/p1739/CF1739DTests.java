package p1739;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1739DTests extends AbstractOjTests {
    public CF1739DTests() {
        super("/p1739/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1739D.main(null);
        super.doAssertion();
    }
}