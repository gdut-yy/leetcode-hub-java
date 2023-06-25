package p1828;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1828D1Tests extends AbstractOjTests {
    public CF1828D1Tests() {
        super("/p1828/D1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1828D1.main(null);
        super.doAssertion();
    }
}