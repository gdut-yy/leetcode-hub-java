package p1790;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1790ETests extends AbstractOjTests {
    public CF1790ETests() {
        super("/p1790/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1790E.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
