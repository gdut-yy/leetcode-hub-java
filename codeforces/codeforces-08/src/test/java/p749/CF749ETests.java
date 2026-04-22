package p749;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF749ETests extends AbstractOjTests {
    public CF749ETests() {
        super("/p749/E/");
    }

    @Test
    @Disabled("浮点数")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF749E.main(null);
        super.doAssertion(OUTPUT1);
    }
}