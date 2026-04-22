package p2064;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2064DTests extends AbstractOjTests {
    public CF2064DTests() {
        super("/p2064/D/");
    }

    @Test
    @Disabled("尾部空格")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2064D.main(null);
        super.doAssertion(OUTPUT1);
    }
}