package p2004;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2004FTests extends AbstractOjTests {
    public CF2004FTests() {
        super("/p2004/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2004F.main(null);
        super.doAssertion(OUTPUT1);
    }
}