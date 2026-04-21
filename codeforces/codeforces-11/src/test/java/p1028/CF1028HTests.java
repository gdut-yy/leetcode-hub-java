package p1028;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1028HTests extends AbstractOjTests {
    public CF1028HTests() {
        super("/p1028/H/");
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1028H.main(null);
        super.doAssertion(OUTPUT1);
    }
}