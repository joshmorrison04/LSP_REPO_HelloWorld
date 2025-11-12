package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

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

    @Test
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals("[]", set.toString());
    }

    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(5);
        set.add(8);
        assertEquals(10, set.largest());
        assertEquals(5, set.smallest());
    }

    @Test
    public void testLargestThrowsExceptionOnEmpty() {
        IntegerSet empty = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> empty.largest());
    }

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


