package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669HTests extends AbstractOjTests {
    public CF1669HTests() {
        super("/p1669/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669H.main(null);
        super.doAssertion();
    }
}
