package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872FTests extends AbstractOjTests {
    public CF1872FTests() {
        super("/p1872/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872F.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}