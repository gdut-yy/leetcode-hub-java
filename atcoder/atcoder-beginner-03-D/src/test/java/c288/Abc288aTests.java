package c288;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc288aTests extends AbstractOjTests {
    public Abc288aTests() {
        super("/c288/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc288_a.main(null);
        super.doAssertion(OUTPUT1);
    }
}