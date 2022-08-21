package ponyai;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai001Tests extends AbstractOjTests {
    public Ponyai001Tests() {
        super("/ponyai/001/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Ponyai001.main(null);
        super.doAssertion();
    }
}
