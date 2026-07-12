package p2035;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2035CTests extends AbstractOjTests {
    public CF2035CTests() {
        super("/p2035/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2035C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
