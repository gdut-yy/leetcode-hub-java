package p1675;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1675DTests extends AbstractOjTests {
    public CF1675DTests() {
        super("/p1675/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1675D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
