package p1194;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1194CTests extends AbstractOjTests {
    public CF1194CTests() {
        super("/p1194/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1194C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
