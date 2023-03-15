package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan003Tests extends AbstractOjTests {
    public Meituan003Tests() {
        super("/meituan/003/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan003.main(null);
        super.doAssertion();
    }
}
