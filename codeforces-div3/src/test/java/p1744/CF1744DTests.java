package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744DTests extends AbstractOjTests {
    public CF1744DTests() {
        super("/p1744/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1744D.main(null);
        super.doAssertion();
    }
}
