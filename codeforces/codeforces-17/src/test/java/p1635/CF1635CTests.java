package p1635;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1635CTests extends AbstractOjTests {
    public CF1635CTests() {
        super("/p1635/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1635C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
