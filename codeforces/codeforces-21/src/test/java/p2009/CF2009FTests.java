package p2009;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2009FTests extends AbstractOjTests {
    public CF2009FTests() {
        super("/p2009/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2009F.main(null);
        super.doAssertion(OUTPUT1);
    }
}