package p1610;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1610ETests extends AbstractOjTests {
    public CF1610ETests() {
        super("/p1610/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1610E.main(null);
        super.doAssertion();
    }
}