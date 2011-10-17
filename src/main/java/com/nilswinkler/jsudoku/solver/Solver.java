package com.nilswinkler.jsudoku.solver;

import org.apache.log4j.Logger;

import com.nilswinkler.jsudoku.data.Grid;

public class Solver {
    private static final Logger LOG = Logger.getLogger(Solver.class);
    
    private long level;
    private long calls;
    
    public boolean solve(Grid grid, int column, int row) {
    	calls++;
    	level++;
    	
        boolean solved = false;
        
        if (!grid.getCell(column, row).isFixed()) {
	        for (int number = 1; number <= grid.getGridSize(); number++) {
	            if (!grid.getCell(column, row).isFixed()) {
	                grid.getCell(column, row).setNumber(number);
	            }
	            
	            if (grid.isColumnValid(column) 
	                    && grid.isRowValid(row) 
	                    && grid.isBlockValid(column, row)) {
	                if (LOG.isDebugEnabled()) {
	                    LOG.debug("valid(" + calls + ", " + level + "): " + column + ", " + row + ": " + number);
	                }
	                
	                boolean nextValid = solveNext(grid, column, row);
	                
	                if (nextValid) {
	                    solved = true;
	                    
	                    break;
	                }
	            }
	        }
        }
        else {
        	solved = solveNext(grid, column, row);
        }
    
        // Backtrack...
        if (!solved && !grid.getCell(column, row).isFixed()) {
            grid.getCell(column, row).setNumber(0);
        }

        level--;
        
        return solved;
    }
    
    private boolean solveNext(Grid grid, int column, int row) {
    	boolean solved = false;
    	
        int nextCol = 0;
        int nextRow = 0;
        
        if (column < grid.getGridSize() - 1) {
            nextCol = column + 1;
            nextRow = row;
        }
        else if (row < grid.getGridSize() - 1) {
            nextCol = 0;
            nextRow = row + 1;
        }
        else {
            solved = true;
        }
        
        if (nextCol != 0 || nextRow != 0) {
        	solved = solve(grid, nextCol, nextRow);
        }
    	
        return solved;
    }
}
