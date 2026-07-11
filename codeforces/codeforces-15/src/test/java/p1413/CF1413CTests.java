package p1413;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1413CTests extends AbstractOjTests {
    public CF1413CTests() {
        super("/p1413/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1413C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1413C.main(null);
        super.doAssertion(OUTPUT2);
    }
}
