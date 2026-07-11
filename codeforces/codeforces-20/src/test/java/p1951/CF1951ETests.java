package p1951;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1951ETests extends AbstractOjTests {
    public CF1951ETests() {
        super("/p1951/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1951E.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
