package p1141;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1141F2Tests extends AbstractOjTests {
    public CF1141F2Tests() {
        super("/p1141/F2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1141F2.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1141F2.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1141F2.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT3);
    }
}