package p1992;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1992FTests extends AbstractOjTests {
    public CF1992FTests() {
        super("/p1992/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1992F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
