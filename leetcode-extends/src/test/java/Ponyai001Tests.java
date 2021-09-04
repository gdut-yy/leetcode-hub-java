import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai001Tests extends AbstractOjTests {
    public Ponyai001Tests() {
        super("ponyai/001");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Ponyai001.main(null);
        super.doAssertion();
    }
}
