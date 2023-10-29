package dwacon5th_prelims;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Dwacon5thPrelimsbTests extends AbstractOjTests {
    public Dwacon5thPrelimsbTests() {
        super("/dwacon5th_prelims/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Dwacon5thPrelims_b.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Dwacon5thPrelims_b.main(null);
        super.doAssertion(OUTPUT2);
    }
}