package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676ETests extends AbstractOjTests {
    public CF1676ETests() {
        super("/p1676/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676E.main(null);
        super.doAssertion();
    }
}
