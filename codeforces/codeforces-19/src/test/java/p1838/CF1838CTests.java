package p1838;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1838CTests extends AbstractOjTests {
    public CF1838CTests() {
        super("/p1838/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1838C.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}