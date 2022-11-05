package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744E1Tests extends AbstractOjTests {
    public CF1744E1Tests() {
        super("/p1744/E1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1744E1.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
