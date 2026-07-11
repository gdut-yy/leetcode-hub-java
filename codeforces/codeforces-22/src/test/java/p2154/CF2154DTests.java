package p2154;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2154DTests extends AbstractOjTests {
    public CF2154DTests() {
        super("/p2154/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2154D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
