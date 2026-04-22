package p2123;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2123ETests extends AbstractOjTests {
    public CF2123ETests() {
        super("/p2123/E/");
    }

    @Test
    @Disabled("尾部空格")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2123E.main(null);
        super.doAssertion(OUTPUT1);
    }
}