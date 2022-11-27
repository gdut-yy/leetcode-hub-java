package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760DTests extends AbstractOjTests {
    public CF1760DTests() {
        super("/p1760/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760D.main(null);
        super.doAssertion();
    }
}
