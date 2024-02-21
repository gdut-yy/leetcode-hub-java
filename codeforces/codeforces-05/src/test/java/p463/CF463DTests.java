package p463;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF463DTests extends AbstractOjTests {
    public CF463DTests() {
        super("/p463/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF463D.main(null);
        super.doAssertion(OUTPUT1);
    }
}