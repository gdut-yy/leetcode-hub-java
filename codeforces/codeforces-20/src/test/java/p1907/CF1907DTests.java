package p1907;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1907DTests extends AbstractOjTests {
    public CF1907DTests() {
        super("/p1907/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1907D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
