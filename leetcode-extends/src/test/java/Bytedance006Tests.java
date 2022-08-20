import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance006Tests extends AbstractOjTests {
    public Bytedance006Tests() {
        super("bytedance/06");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Bytedance006.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetInOut(INPUT2, OUTPUT2);
        Bytedance006.main(null);
        super.doAssertion();
    }

    @Test
    public void example3() throws IOException {
        super.doSetInOut(INPUT3, OUTPUT3);
        Bytedance006.main(null);
        super.doAssertion();
    }
}
