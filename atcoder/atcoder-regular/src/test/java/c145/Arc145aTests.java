package c145;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Arc145aTests extends AbstractOjTests {
    public Arc145aTests() {
        super("/c145/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Arc145_a.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Arc145_a.main(null);
        super.doAssertion(OUTPUT2);
    }
}