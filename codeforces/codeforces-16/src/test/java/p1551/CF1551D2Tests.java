package p1551;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1551D2Tests extends AbstractOjTests {
    public CF1551D2Tests() {
        super("/p1551/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1551D2.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}