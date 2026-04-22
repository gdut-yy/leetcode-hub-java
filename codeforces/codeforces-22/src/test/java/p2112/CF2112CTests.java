package p2112;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2112CTests extends AbstractOjTests {
    public CF2112CTests() {
        super("/p2112/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2112C.main(null);
        super.doAssertion(OUTPUT1);
    }
}