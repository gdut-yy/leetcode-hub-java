package nc60456;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC60456DTests extends AbstractOjTests {
    public NC60456DTests() {
        super("/nc60456/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC60456D.main(null);
        super.doAssertion(OUTPUT1);
    }
}