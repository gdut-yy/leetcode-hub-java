package p1838;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1838ETests extends AbstractOjTests {
    public CF1838ETests() {
        super("/p1838/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1838E.main(null);
        super.doAssertion();
    }
}