package ponyai;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai005Tests extends AbstractOjTests {
    public Ponyai005Tests() {
        super("/ponyai/005/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Ponyai005.main(null);
        super.doAssertion();
    }
}
