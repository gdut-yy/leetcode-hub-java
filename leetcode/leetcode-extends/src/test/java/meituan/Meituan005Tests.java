package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan005Tests extends AbstractOjTests {
    public Meituan005Tests() {
        super("/meituan/005/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan005.main(null);
        super.doAssertion();
    }
}
