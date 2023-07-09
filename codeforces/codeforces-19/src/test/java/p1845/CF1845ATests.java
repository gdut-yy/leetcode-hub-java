package p1845;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1845ATests extends AbstractOjTests {
    public CF1845ATests() {
        super("/p1845/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1845A.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}