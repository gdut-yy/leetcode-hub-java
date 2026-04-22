package p1791;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1791FTests extends AbstractOjTests {
    public CF1791FTests() {
        super("/p1791/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1791F.main(null);
        super.doAssertion(OUTPUT1);
    }
}