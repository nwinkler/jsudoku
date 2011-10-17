package com.nilswinkler.jsudoku.solver;

import com.nilswinkler.jsudoku.data.Cell;
import com.nilswinkler.jsudoku.data.Grid;

import junit.framework.TestCase;

public class TestSolver extends TestCase {

    /*
     * Test method for 'com.nilswinkler.jsudoku.solver.Solver.solve(Grid, int, int)'
     */
    public void testSolve() {
        Grid grid = new Grid(4);
        
        grid.setCell(0, 0, new Cell(1, true));
        grid.setCell(0, 1, new Cell(2, true));
        grid.setCell(0, 2, new Cell(3, true));
        grid.setCell(0, 3, new Cell(4, true));
        
        Solver solver = new Solver();
        assertTrue(solver.solve(grid, 0, 0));
        
        assertEquals(3, grid.getCell(1, 0).getNumber());
        assertEquals(4, grid.getCell(1, 1).getNumber());
        assertEquals(1, grid.getCell(1, 2).getNumber());
        assertEquals(2, grid.getCell(1, 3).getNumber());
        
        for (int col = 0; col < grid.getGridSize(); col++) {
            for (int row = 0; row < grid.getGridSize(); row++) {
                assertTrue(grid.isColumnValid(col));
                assertTrue(grid.isRowValid(col));
                assertTrue(grid.isBlockValid(col, row));
            }
        }
    }

}
