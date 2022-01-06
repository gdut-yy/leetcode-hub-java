package p1621;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1621ATests extends AbstractOjTests {
    public CF1621ATests() {
        super("/p1621/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1621A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
