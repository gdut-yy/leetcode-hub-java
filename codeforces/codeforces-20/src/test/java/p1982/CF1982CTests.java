package p1982;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1982CTests extends AbstractOjTests {
    public CF1982CTests() {
        super("/p1982/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1982C.main(null);
        super.doAssertion(OUTPUT1);
    }
}