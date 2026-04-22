package p1999;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1999FTests extends AbstractOjTests {
    public CF1999FTests() {
        super("/p1999/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1999F.main(null);
        super.doAssertion(OUTPUT1);
    }
}