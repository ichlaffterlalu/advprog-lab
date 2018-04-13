package tallycounter;

public class BasicTallyCounter implements TallyCounter {
    private int counter = 0;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int value() {
        return counter;
    }
}
