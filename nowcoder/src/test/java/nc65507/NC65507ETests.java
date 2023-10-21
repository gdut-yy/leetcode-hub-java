package nc65507;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65507ETests extends AbstractOjTests {
    public NC65507ETests() {
        super("/nc65507/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65507E.main(null);
        super.doAssertion(OUTPUT1);
    }
}