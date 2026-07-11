package p2040;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2040DTests extends AbstractOjTests {
    public CF2040DTests() {
        super("/p2040/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2040D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
