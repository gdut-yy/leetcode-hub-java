import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai003Tests extends AbstractOjTests {
    public Ponyai003Tests() {
        super("/ponyai/003/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Ponyai003.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Ponyai003.main(null);
        super.doAssertion(OUTPUT2);
    }
}
