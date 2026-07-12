package c347;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Abc347dTests extends AbstractOjTests {
    public Abc347dTests() {
        super("/c347/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc347_d.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc347_d.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc347_d.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT3);
    }
}
