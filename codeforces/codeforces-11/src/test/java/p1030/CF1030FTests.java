package p1030;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1030FTests extends AbstractOjTests {
    public CF1030FTests() {
        super("/p1030/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1030F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
