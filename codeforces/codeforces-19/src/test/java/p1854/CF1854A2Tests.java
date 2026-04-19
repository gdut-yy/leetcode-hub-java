package p1854;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1854A2Tests extends AbstractOjTests {
    public CF1854A2Tests() {
        super("/p1854/A2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1854A2.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}