package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan002Tests extends AbstractOjTests {
    public Meituan002Tests() {
        super("/meituan/002/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan002.main(null);
        super.doAssertion();
    }
}
