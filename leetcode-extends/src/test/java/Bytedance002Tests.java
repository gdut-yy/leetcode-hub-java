import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance002Tests extends AbstractOjTests {
    public Bytedance002Tests() {
        super("bytedance/02");
    }

    @Test
    public void example1() throws IOException {
        super.doSetInOut();
        Bytedance002.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetInOut(INPUT2, OUTPUT2);
        Bytedance002.main(null);
        super.doAssertion();
    }
}
