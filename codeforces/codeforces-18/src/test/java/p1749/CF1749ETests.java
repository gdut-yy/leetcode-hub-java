package p1749;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1749ETests extends AbstractOjTests {
    public CF1749ETests() {
        super("/p1749/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1749E.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}