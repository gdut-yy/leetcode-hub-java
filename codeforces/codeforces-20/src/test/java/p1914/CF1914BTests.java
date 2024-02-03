package p1914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1914BTests extends AbstractOjTests {
    public CF1914BTests() {
        super("/p1914/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1914B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}