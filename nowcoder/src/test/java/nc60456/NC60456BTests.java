package nc60456;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC60456BTests extends AbstractOjTests {
    public NC60456BTests() {
        super("/nc60456/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC60456B.main(null);
        super.doAssertion(OUTPUT1);
    }
}