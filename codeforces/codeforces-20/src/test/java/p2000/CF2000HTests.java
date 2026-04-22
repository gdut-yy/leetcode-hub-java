package p2000;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2000HTests extends AbstractOjTests {
    public CF2000HTests() {
        super("/p2000/H/");
    }

    @Test
    @Disabled("尾部空格")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2000H.main(null);
        super.doAssertion(OUTPUT1);
    }
}