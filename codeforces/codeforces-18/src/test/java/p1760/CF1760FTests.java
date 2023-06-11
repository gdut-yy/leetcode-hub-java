package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760FTests extends AbstractOjTests {
    public CF1760FTests() {
        super("/p1760/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760F.main(null);
        super.doAssertion();
    }
}
