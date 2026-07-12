package p2071;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2071BTests extends AbstractOjTests {
    public CF2071BTests() {
        super("/p2071/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2071B.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
