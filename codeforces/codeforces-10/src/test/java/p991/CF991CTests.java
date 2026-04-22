package p991;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF991CTests extends AbstractOjTests {
    public CF991CTests() {
        super("/p991/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF991C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
