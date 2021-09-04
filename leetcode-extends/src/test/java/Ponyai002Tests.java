import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai002Tests extends AbstractOjTests {
    public Ponyai002Tests() {
        super("ponyai/002");
    }

    //    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Ponyai002.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetInOut(INPUT2, OUTPUT2);
        Ponyai002.main(null);
        super.doAssertion();
    }
}
