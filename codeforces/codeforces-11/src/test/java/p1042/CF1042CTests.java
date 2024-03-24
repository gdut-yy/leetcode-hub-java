package p1042;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1042CTests extends AbstractOjTests {
    public CF1042CTests() {
        super("/p1042/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1042C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1042C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1042C.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF1042C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT4);
    }

    @Test
    public void example5() throws IOException {
        super.doSetSystemInOut(INPUT5);
        CF1042C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT5);
    }
}