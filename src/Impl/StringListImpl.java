package Impl;

import Exception.IncorrectCapacityException;
import Exception.IncorrectIndexException;
import Exception.ItemIsNullException;
import Interface.StringList;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

public class StringListImpl implements StringList {

    private final static int defaultCapacity = 10;

    private final String[] storage;
    private int capacity;

    public StringListImpl() {
        storage = new String[defaultCapacity];
        capacity = 0;
    }

    public StringListImpl(int capacity) {
        if (capacity <= 0) {
            throw new IncorrectCapacityException("Параметр capacity должен быть больше 0");
        }
        storage = new String[capacity];
        capacity = 0;
    }


    @Override
    public String add(String item) {
        return add(capacity, item);
    }

    @Override
    public String add(int index, String item) {
        checkIsNull(item);
        if (capacity == storage.length) {
            throw new IncorrectIndexException();
        }
        checkIndex(index, false);
        if (index < capacity) {
            System.arraycopy(storage, index, storage, index + 1, capacity - index);
        }
        storage[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIsNull(item);
        checkIndex(index, true);
        return storage[index] = item;
    }

    @Override
    public String remove(String item) {
        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        checkIndex(index, true);
        if (index < capacity - 1) {
            System.arraycopy(storage, index + 1, storage, index, capacity - index - 1);
        }
        String removed = storage[index];
        storage[capacity - 1] = null;
        capacity--;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        checkIsNull(item);
        for (int i = 0; i < capacity; i++) {
            if (storage[i].contains(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkIsNull(item);
        for (int i = 0; i < capacity; i++) {
            if (storage[i].contains(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkIsNull(item);
        for (int i = capacity - 1; i >= 0; i--) {
            if (storage[i].contains(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index, true);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!storage[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            storage[i] = null;
        }
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, capacity);
    }

    private void checkIsNull(String item) {
        if (Objects.isNull(item)) {
            throw new ItemIsNullException();
        }
    }

    private void checkIndex(int index, boolean include) {

        if (index < 0 || include ? index >= capacity : index > capacity) {
            throw new IncorrectIndexException();
        }
    }

}
