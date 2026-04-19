package p1878;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1878FTests extends AbstractOjTests {
    public CF1878FTests() {
        super("/p1878/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1878F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
