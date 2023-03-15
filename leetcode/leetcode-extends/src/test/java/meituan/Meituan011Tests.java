package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan011Tests extends AbstractOjTests {
    public Meituan011Tests() {
        super("/meituan/011/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan011.main(null);
        super.doAssertion();
    }
}
