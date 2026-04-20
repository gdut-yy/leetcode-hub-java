package p2040;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2040CTests extends AbstractOjTests {
    public CF2040CTests() {
        super("/p2040/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2040C.main(null);
        super.doAssertion(OUTPUT1);
    }

    // 补充用例
    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF2040C.main(null);
        super.doAssertion(OUTPUT2);
    }
}