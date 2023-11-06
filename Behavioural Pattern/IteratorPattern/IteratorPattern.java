import java.util.Iterator;

interface MyIterator<T> {
    boolean hasNext();
    T next();
}

class MyCollection<T> {
    private T[] elements;

    public MyCollection(T[] elements) {
        this.elements = elements;
    }

    public MyIterator<T> createIterator() {
        return new MyArrayIterator();
    }

    private class MyArrayIterator implements MyIterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return elements[index++];
            } else {
                throw new RuntimeException("No more elements");
            }
        }
    }
}

class IteratorPattern {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        MyCollection<Integer> collection = new MyCollection<>(numbers);

        MyIterator<Integer> iterator = collection.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
