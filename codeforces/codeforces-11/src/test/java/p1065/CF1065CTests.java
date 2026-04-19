package p1065;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1065CTests extends AbstractOjTests {
    public CF1065CTests() {
        super("/p1065/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1065C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1065C.main(null);
        super.doAssertion(OUTPUT2);
    }
}
