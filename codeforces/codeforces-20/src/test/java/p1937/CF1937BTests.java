package p1937;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1937BTests extends AbstractOjTests {
    public CF1937BTests() {
        super("/p1937/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1937B.main(null);
        super.doAssertion(OUTPUT1);
    }
}