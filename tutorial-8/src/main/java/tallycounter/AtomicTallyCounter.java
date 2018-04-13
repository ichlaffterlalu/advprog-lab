package tallycounter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTallyCounter implements TallyCounter {
    private AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public int value() {
        return counter.get();
    }
}
