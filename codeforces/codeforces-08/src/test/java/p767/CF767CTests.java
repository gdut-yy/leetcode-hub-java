package p767;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF767CTests extends AbstractOjTests {
    public CF767CTests() {
        super("/p767/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF767C.main(null);
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF767C.main(null);
        super.doAssertion(OUTPUT2);
    }
}