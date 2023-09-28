package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872GTests extends AbstractOjTests {
    public CF1872GTests() {
        super("/p1872/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872G.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}