package p1270;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1270FTests extends AbstractOjTests {
    public CF1270FTests() {
        super("/p1270/F/");
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1270F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1270F.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1270F.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF1270F.main(null);
        super.doAssertion(OUTPUT4);
    }
}