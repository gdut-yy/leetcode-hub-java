package c292;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc292aTests extends AbstractOjTests {
    public Abc292aTests() {
        super("/c292/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc292_a.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc292_a.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc292_a.main(null);
        super.doAssertion(OUTPUT3);
    }
}