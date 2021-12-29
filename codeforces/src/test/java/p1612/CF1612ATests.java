package p1612;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1612ATests extends AbstractOjTests {
    public CF1612ATests() {
        super("/p1612/A/");
    }

    /**
     * 答案不唯一
     *
     * @throws IOException Exception
     */
    @Test
    @Disabled
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1612A.main(null);
        super.doAssertion();
    }
}
