package c459;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc459dTests extends AbstractOjTests {
    public Abc459dTests() {
        super("/c459/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc459_d.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
