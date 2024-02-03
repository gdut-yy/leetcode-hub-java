package p1914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1914DTests extends AbstractOjTests {
    public CF1914DTests() {
        super("/p1914/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1914D.main(null);
        super.doAssertion(OUTPUT1);
    }
}