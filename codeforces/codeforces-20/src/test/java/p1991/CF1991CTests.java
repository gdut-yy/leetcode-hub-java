package p1991;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1991CTests extends AbstractOjTests {
    public CF1991CTests() {
        super("/p1991/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1991C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
