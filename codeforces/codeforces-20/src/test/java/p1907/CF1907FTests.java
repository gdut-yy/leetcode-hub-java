package p1907;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1907FTests extends AbstractOjTests {
    public CF1907FTests() {
        super("/p1907/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1907F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
