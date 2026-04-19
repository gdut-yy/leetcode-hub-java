package p2052;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2052FTests extends AbstractOjTests {
    public CF2052FTests() {
        super("/p2052/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2052F.main(null);
        super.doAssertion(OUTPUT1);
    }
}