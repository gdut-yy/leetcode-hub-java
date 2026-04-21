package p1701;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1701FTests extends AbstractOjTests {
    public CF1701FTests() {
        super("/p1701/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1701F.main(null);
        super.doAssertion(OUTPUT1);
    }
}