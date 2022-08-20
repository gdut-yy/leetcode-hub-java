import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance004Tests extends AbstractOjTests {
    public Bytedance004Tests() {
        super("bytedance/04");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Bytedance004.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetInOut(INPUT2, OUTPUT2);
        Bytedance004.main(null);
        super.doAssertion();
    }

    @Test
    public void example3() throws IOException {
        super.doSetInOut(INPUT3, OUTPUT3);
        Bytedance004.main(null);
        super.doAssertion();
    }
}
