package p1547;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1547ETests extends AbstractOjTests {
    public CF1547ETests() {
        super("/p1547/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1547E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
