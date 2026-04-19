package p2008;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2008FTests extends AbstractOjTests {
    public CF2008FTests() {
        super("/p2008/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2008F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
