package meituan;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Meituan009Tests extends AbstractOjTests {
    public Meituan009Tests() {
        super("/meituan/009/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Meituan009.main(null);
        super.doAssertion();
    }
}
