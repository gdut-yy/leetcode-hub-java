package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702DTests extends AbstractOjTests {
    public CF1702DTests() {
        super("/p1702/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}
