package p1186;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1186DTests extends AbstractOjTests {
    public CF1186DTests() {
        super("/p1186/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1186D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1186D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT2);
    }
}