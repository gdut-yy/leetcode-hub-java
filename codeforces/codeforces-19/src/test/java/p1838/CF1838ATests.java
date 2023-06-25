package p1838;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1838ATests extends AbstractOjTests {
    public CF1838ATests() {
        super("/p1838/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1838A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}