package p1974;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1974DTests extends AbstractOjTests {
    public CF1974DTests() {
        super("/p1974/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1974D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}