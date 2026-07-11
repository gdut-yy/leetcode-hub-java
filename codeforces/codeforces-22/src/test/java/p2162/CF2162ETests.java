package p2162;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2162ETests extends AbstractOjTests {
    public CF2162ETests() {
        super("/p2162/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2162E.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
