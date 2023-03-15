package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744E2Tests extends AbstractOjTests {
    public CF1744E2Tests() {
        super("/p1744/E2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1744E2.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
