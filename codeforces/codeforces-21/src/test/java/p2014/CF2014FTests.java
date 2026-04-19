package p2014;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2014FTests extends AbstractOjTests {
    public CF2014FTests() {
        super("/p2014/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2014F.main(null);
        super.doAssertion(OUTPUT1);
    }
}