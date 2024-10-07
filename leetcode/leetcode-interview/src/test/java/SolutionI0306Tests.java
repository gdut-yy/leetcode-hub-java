import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0306Tests {
    @Test
    public void example1() {
        SolutionI0306.AnimalShelf animalShelf = new SolutionI0306.AnimalShelf();
        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        Assertions.assertArrayEquals(new int[]{0, 0}, animalShelf.dequeueCat());
        Assertions.assertArrayEquals(new int[]{-1, -1}, animalShelf.dequeueDog());
        Assertions.assertArrayEquals(new int[]{1, 0}, animalShelf.dequeueAny());
    }

    @Test
    public void example2() {
        SolutionI0306.AnimalShelf animalShelf = new SolutionI0306.AnimalShelf();
        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        animalShelf.enqueue(new int[]{2, 1});
        Assertions.assertArrayEquals(new int[]{2, 1}, animalShelf.dequeueDog());
        Assertions.assertArrayEquals(new int[]{0, 0}, animalShelf.dequeueCat());
        Assertions.assertArrayEquals(new int[]{1, 0}, animalShelf.dequeueAny());
    }
}