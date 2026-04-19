package p2000;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2000FTests extends AbstractOjTests {
    public CF2000FTests() {
        super("/p2000/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2000F.main(null);
        super.doAssertion(OUTPUT1);
    }
}