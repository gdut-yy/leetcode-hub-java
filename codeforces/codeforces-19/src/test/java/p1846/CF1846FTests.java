package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846FTests extends AbstractOjTests {
    public CF1846FTests() {
        super("/p1846/F/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846F.main(null);
        super.doAssertion();
    }
}