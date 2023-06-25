package p1834;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1834DTests extends AbstractOjTests {
    public CF1834DTests() {
        super("/p1834/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1834D.main(null);
        super.doAssertion();
    }
}