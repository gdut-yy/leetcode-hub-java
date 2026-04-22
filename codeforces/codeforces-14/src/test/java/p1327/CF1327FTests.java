package p1327;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1327FTests extends AbstractOjTests {
    public CF1327FTests() {
        super("/p1327/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1327F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1327F.main(null);
        super.doAssertion(OUTPUT2);
    }
}