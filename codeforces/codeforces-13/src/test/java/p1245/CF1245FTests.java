package p1245;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1245FTests extends AbstractOjTests {
    public CF1245FTests() {
        super("/p1245/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1245F.main(null);
        super.doAssertion(OUTPUT1);
    }
}