package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807ETests extends AbstractOjTests {
    public CF1807ETests() {
        super("/p1807/E/");
    }

    // 交互题
    @Test
    @Disabled
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807E.main(null);
        super.doAssertion();
    }
}
