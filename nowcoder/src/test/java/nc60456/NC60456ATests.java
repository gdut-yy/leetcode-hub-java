package nc60456;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC60456ATests extends AbstractOjTests {
    public NC60456ATests() {
        super("/nc60456/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC60456A.main(null);
        super.doAssertion(OUTPUT1);
    }
}