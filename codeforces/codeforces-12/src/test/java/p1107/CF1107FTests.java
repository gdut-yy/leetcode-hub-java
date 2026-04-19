package p1107;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1107FTests extends AbstractOjTests {
    public CF1107FTests() {
        super("/p1107/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1107F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1107F.main(null);
        super.doAssertion(OUTPUT2);
    }
}
