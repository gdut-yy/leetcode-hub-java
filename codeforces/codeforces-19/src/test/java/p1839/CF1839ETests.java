package p1839;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1839ETests extends AbstractOjTests {
    public CF1839ETests() {
        super("/p1839/E/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1839E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("交互题")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1839E.main(null);
        super.doAssertion(OUTPUT2);
    }
}