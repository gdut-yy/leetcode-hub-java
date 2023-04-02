package p1624;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1624ETests extends AbstractOjTests {
    public CF1624ETests() {
        super("/p1624/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1624E.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}