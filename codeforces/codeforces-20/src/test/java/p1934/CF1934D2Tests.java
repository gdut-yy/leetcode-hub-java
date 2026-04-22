package p1934;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1934D2Tests extends AbstractOjTests {
    public CF1934D2Tests() {
        super("/p1934/D2/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1934D2.main(null);
        super.doAssertion(OUTPUT1);
    }
}