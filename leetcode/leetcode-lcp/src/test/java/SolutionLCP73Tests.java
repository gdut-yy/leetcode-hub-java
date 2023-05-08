import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP73Tests {
    private final SolutionLCP73 solutionLCP73 = new SolutionLCP73();

    @Test
    public void example1() {
        String[] expeditions = {"leet->code", "leet->code->Campsite->Leet", "leet->code->leet->courier"};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP73.adventureCamp(expeditions));
    }

    @Test
    public void example2() {
        String[] expeditions = {"Alice->Dex", "", "Dex"};
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP73.adventureCamp(expeditions));
    }

    @Test
    public void example3() {
        String[] expeditions = {"", "Gryffindor->Slytherin->Gryffindor", "Hogwarts->Hufflepuff->Ravenclaw"};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP73.adventureCamp(expeditions));
    }
}