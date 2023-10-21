package nc65051;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65051DTests extends AbstractOjTests {
    public NC65051DTests() {
        super("/nc65051/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65051D.main(null);
        super.doAssertion(OUTPUT1);
    }
}