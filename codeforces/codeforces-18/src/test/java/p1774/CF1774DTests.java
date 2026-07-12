package p1774;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1774DTests extends AbstractOjTests {
    public CF1774DTests() {
        super("/p1774/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1774D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
