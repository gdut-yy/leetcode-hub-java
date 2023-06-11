package p1734;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1734DTests extends AbstractOjTests {
    public CF1734DTests() {
        super("/p1734/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1734D.main(null);
        super.doAssertion();
    }
}