package nc65051;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65051ATests extends AbstractOjTests {
    public NC65051ATests() {
        super("/nc65051/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65051A.main(null);
        super.doAssertion(OUTPUT1);
    }
}