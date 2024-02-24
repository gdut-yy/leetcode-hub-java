package p1221;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1221DTests extends AbstractOjTests {
    public CF1221DTests() {
        super("/p1221/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1221D.main(null);
        super.doAssertion(OUTPUT1);
    }
}