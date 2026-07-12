package p1333;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1333ATests extends AbstractOjTests {
    public CF1333ATests() {
        super("/p1333/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1333A.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
