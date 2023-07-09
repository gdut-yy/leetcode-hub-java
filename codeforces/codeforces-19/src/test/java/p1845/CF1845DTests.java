package p1845;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1845DTests extends AbstractOjTests {
    public CF1845DTests() {
        super("/p1845/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1845D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}