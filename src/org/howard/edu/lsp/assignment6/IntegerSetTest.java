package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    // Tests add(), contains(), length(), and toString()
    @Test
    public void testAddAndContainsAndToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);
        assertTrue(set.contains(1));
        assertFalse(set.contains(3));
        assertEquals("[1, 2]", set.toString());
        assertEquals(2, set.length());
    }

    // Tests clear() and isEmpty()
    @Test
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals("[]", set.toString());
    }

    // Tests largest() and smallest()
    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(5);
        set.add(8);
        assertEquals(10, set.largest());
        assertEquals(5, set.smallest());
    }

    // Tests that largest() throws an exception when the set is empty
    @Test
    public void testLargestThrowsExceptionOnEmpty() {
        IntegerSet empty = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> empty.largest());
    }

    // Tests equals() when sets contain the same values in different order
    @Test
    public void testEqualsTrueWhenSameValuesDifferentOrder() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1);
        a.add(2);
        b.add(2);
        b.add(1);
        assertTrue(a.equals(b));
    }

    // Tests equals() when sets contain different values
    @Test
    public void testEqualsFalseWhenDifferentValues() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1);
        a.add(2);
        b.add(1);
        b.add(3);
        assertFalse(a.equals(b));
    }

    // Tests union() to make sure both sets' elements are combined
    @Test
    public void testUnion() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        a.union(b);
        assertEquals("[1, 2, 3]", a.toString());
    }

    // Tests intersect() to keep only common elements
    @Test
    public void testIntersect() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        a.intersect(b);
        assertEquals("[2]", a.toString());
    }

    // Tests diff() to remove elements found in the other set
    @Test
    public void testDiff() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        a.diff(b);
        assertEquals("[1]", a.toString());
    }

    // Tests complement() to make sure the set becomes (other \ this)
    @Test
    public void testComplement() {
        IntegerSet a = new IntegerSet();
        a.add(1);
        a.add(2);
        IntegerSet b = new IntegerSet();
        b.add(2);
        b.add(3);
        a.complement(b);
        assertEquals("[3]", a.toString());
    }
}


