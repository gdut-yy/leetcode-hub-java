package p1363;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1363BTests extends AbstractOjTests {
    public CF1363BTests() {
        super("/p1363/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1363B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
