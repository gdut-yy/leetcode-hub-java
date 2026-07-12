package p2072;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2072CTests extends AbstractOjTests {
    public CF2072CTests() {
        super("/p2072/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2072C.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
