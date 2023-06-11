package p1272;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1272ETests extends AbstractOjTests {
    public CF1272ETests() {
        super("/p1272/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1272E.main(null);
        super.doAssertion();
    }
}