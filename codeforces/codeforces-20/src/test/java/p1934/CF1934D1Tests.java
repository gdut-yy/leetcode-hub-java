package p1934;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1934D1Tests extends AbstractOjTests {
    public CF1934D1Tests() {
        super("/p1934/D1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1934D1.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}