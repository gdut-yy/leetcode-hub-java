package ponyai;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai004Tests extends AbstractOjTests {
    public Ponyai004Tests() {
        super("/ponyai/004/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Ponyai004.main(null);
        super.doAssertion();
    }
}
