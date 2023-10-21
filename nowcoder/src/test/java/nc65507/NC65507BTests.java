package nc65507;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65507BTests extends AbstractOjTests {
    public NC65507BTests() {
        super("/nc65507/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65507B.main(null);
        super.doAssertion(OUTPUT1);
    }
}