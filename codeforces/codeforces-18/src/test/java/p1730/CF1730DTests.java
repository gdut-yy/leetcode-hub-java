package p1730;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1730DTests extends AbstractOjTests {
    public CF1730DTests() {
        super("/p1730/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1730D.main(null);
        super.doAssertion(OUTPUT1);
    }
}