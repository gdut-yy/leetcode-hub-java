package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760ETests extends AbstractOjTests {
    public CF1760ETests() {
        super("/p1760/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760E.main(null);
        super.doAssertion();
    }
}
