import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Задание: Изучить и реализовать {@link Iterator}.
 *
 * @author upagge [02.09.2019]
 */
public class Stock implements Iterable<String> {

    private int size;
    private String[] strings;

    public Stock(String... strings) {
        this.size = strings.length;
        this.strings = Arrays.copyOf(strings, strings.length);
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {

        private int index;
        private int downSize = strings.length;

        @Override
        public boolean hasNext() {
            return index < downSize;
        }

        @Override
        public String next() {
            if (hasNext()) {
                if (strings.length != downSize) {
                    throw new ConcurrentModificationException("Entities has been changed");
                } else {
                    return strings[index++];
                }
            } else {
                throw new NoSuchElementException("no such element");
            }
        }

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("Illegal position");
            }
            for (int i = index - 1; i < (strings.length - 1); i++) {
                strings[i] = strings[i + 1];
            }
            strings = Arrays.copyOf(strings, size - 1);
            downSize--;
            index--;
        }

    }

}
