package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760ATests extends AbstractOjTests {
    public CF1760ATests() {
        super("/p1760/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760A.main(null);
        super.doAssertion();
    }
}
