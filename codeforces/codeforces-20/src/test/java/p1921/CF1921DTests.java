package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921DTests extends AbstractOjTests {
    public CF1921DTests() {
        super("/p1921/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
