package p1828;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1828ATests extends AbstractOjTests {
    public CF1828ATests() {
        super("/p1828/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1828A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}