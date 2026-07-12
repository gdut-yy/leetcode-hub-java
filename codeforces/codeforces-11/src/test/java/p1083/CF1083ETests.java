package p1083;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1083ETests extends AbstractOjTests {
    public CF1083ETests() {
        super("/p1083/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1083E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1083E.main(null);
        super.doAssertion(OUTPUT2);
    }
}
