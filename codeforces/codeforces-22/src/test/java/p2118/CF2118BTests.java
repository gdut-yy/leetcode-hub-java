package p2118;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2118BTests extends AbstractOjTests {
    public CF2118BTests() {
        super("/p2118/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2118B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
