package p1612;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1612BTests extends AbstractOjTests {
    public CF1612BTests() {
        super("p1612/B/");
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
        CF1612B.main(null);
        super.doAssertion();
    }
}
