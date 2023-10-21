package nc65507;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65507DTests extends AbstractOjTests {
    public NC65507DTests() {
        super("/nc65507/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65507D.main(null);
        super.doAssertion(OUTPUT1);
    }
}