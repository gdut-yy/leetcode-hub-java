package p1753;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1753A2Tests extends AbstractOjTests {
    public CF1753A2Tests() {
        super("/p1753/A2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1753A2.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
