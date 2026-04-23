package p2114;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2114ETests extends AbstractOjTests {
    public CF2114ETests() {
        super("/p2114/E/");
    }

    @Test
    @Disabled("尾部空格")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2114E.main(null);
        super.doAssertion(OUTPUT1);
    }
}