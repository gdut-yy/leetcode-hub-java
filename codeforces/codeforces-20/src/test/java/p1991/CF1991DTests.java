package p1991;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1991DTests extends AbstractOjTests {
    public CF1991DTests() {
        super("/p1991/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1991D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
