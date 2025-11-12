package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet  {
    // Internal storage for the set elements
    private List<Integer> set = new ArrayList<Integer>();

    // Removes all elements from the set
    public void clear() {
        set.clear();
    }

    // Returns the number of elements in the set
    public int length() {
        return set.size();
    }

    // Checks if the set is empty
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // Adds an item to the set if it is not already present
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    // Checks whether the set contains a specific value
    public boolean contains(int value) {
        return set.contains(value);
    }

    // Returns a string representation of the set
    @Override
    public String toString() {
        return set.toString();
    }

    // Returns the largest element in the set
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        int max = set.get(0);
        for (int value : set) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Returns the smallest element in the set
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        int min = set.get(0);
        for (int value : set) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Compares two IntegerSets for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;

        IntegerSet other = (IntegerSet) o;
        return set.containsAll(other.set) && other.set.containsAll(set);
    }

    // Set Union: Contain all unique elements in this or other
    public void union(IntegerSet other) {
        for (int value : other.set) {
            if (!set.contains(value)) {
                set.add(value);
            }
        }
    }

    // Keep elements that appear in both sets
    public void intersect(IntegerSet other) {
        set.retainAll(other.set);
    }

    // Removes from this all elements found in the other
    public void diff(IntegerSet other) {
        set.removeAll(other.set);
    }

    // Set complement: other / this
    public void complement(IntegerSet other) {
        List<Integer> newSet = new ArrayList<>(other.set);
        newSet.removeAll(set);
        set = newSet;
    }
}


