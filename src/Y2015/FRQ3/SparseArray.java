package Y2015.FRQ3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseArray {
    /**
     * The number of rows and columns in the sparse array.
     */
    private int numRows;
    private int numCols;
    /**
     * The list of entries representing the non-zero elements of the sparse array. Entries are stored in the
     * list in no particular order. Each non-zero element is represented by exactly one entry in the list.
     */
    private List<SparseArrayEntry> entries;

    /**
     * Constructs an empty SparseArray.
     */
    public SparseArray() {
        this.entries = new ArrayList<>();
    }

    /**
     * Constructs a SparseArray with entries.
     */
    public SparseArray(int numRows, int numCols, SparseArrayEntry... entries) {
        this.numRows = numRows;
        this.numCols = numCols;

        this.entries = new ArrayList<>(entries.length);
        this.entries.addAll(Arrays.asList(entries));
    }

    /**
     * Returns the number of rows in the sparse array.
     */
    public int getNumRows() {
        return this.numRows;
    }

    /**
     * Returns the number of columns in the sparse array.
     */
    public int getNumCols() {
        return this.numCols;
    }

    /**
     * Returns the value of the element at row index row and column index col in the sparse array.
     * Precondition: 0 <= row < getNumRows()
     * 0 <=  col < getNumCols()
     */
    public int getValueAt(int row, int col) {
        for (SparseArrayEntry entry : this.entries) {
            if (entry.getCol() == col && entry.getRow() == row) {
                return entry.getValue();
            }
        }

        return 0;
    }

    /**
     * Removes the column col from the sparse array.
     * Precondition: 0 <= col < getNumCols()
     */
    public void removeColumn(int col) {
        this.entries.removeIf(entry -> entry.getCol() == col);
        this.numCols--;
    }

    /**
     * Used for testing
     */
    public static void main(String[] args) throws Exception {
        SparseArray arr = new SparseArray(
                6,
                5,
                new SparseArrayEntry(1, 4, 4),
                new SparseArrayEntry(2, 0, 1),
                new SparseArrayEntry(3, 1, -9),
                new SparseArrayEntry(1, 1, 5)
        );

        int existingValue = arr.getValueAt(3, 1);
        if(existingValue != -9) {
            throw new Exception("Method getValueAt does not work! Expected: -9, Actual: " + existingValue);
        }

        int nonExistingValue = arr.getValueAt(3, 3);
        if(nonExistingValue != 0) {
            throw new Exception("Method getValueAt does not work! Expected: 0, Actual: " + nonExistingValue);
        }

        arr.removeColumn(1);
        if(arr.getNumCols() != 4) {
            throw new Exception("Method removeColumn does not work (# of cols)! Expected: 4, Actual: " + arr.getNumCols());
        }
        if(arr.entries.size() != 2) {
            throw new Exception("Method removeColumn does not work (# of entries)! Expected: 2, Actual: " + arr.entries.size());
        }
    }
}