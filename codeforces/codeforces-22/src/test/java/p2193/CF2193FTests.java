package p2193;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2193FTests extends AbstractOjTests {
    public CF2193FTests() {
        super("/p2193/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2193F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
