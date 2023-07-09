package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846E2Tests extends AbstractOjTests {
    public CF1846E2Tests() {
        super("/p1846/E2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846E2.main(null);
        super.doAssertion();
    }
}