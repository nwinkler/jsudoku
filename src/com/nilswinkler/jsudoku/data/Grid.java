package com.nilswinkler.jsudoku.data;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Grid {
	private Cell[][] cells = null;
    private final int blockSize;
    private final int gridSize;

	public Grid(int gridSize) {
        this.gridSize = gridSize;
        this.blockSize = (int) Math.sqrt(gridSize);

        cells = new Cell[gridSize][gridSize];
		for (int column = 0; column < gridSize; column++) {
			for (int row = 0; row < gridSize; row++) {
				cells[column][row] = new Cell();
			}
		}
	}
	
	public Cell getCell(int column, int row) {
		return cells[column][row];
	}
	
	public void setCell(int column, int row, Cell cell) {
		cells[column][row] = cell;
	}
	
	public boolean isColumnValid(int column) {
		boolean ret = true;
		
		Validator val = new Validator();
		
		Cell[] columnCells = cells[column];
		
		for (int i = 0; i < columnCells.length; i++) {
			Cell cell = columnCells[i];
			
			if (val.contains(cell.getNumber())) {
				ret = false;
				
				break;
			}
			
			val.add(cell.getNumber());
		}
		
		return ret;
	}
	
	public boolean isRowValid(int row) {
		boolean ret = true;
		
		Validator val = new Validator();
		
		for (int col = 0; col < cells.length; col++) {
			Cell cell = cells[col][row];
			
			if (val.contains(cell.getNumber())) {
				ret = false;
				
				break;
			}
			
			val.add(cell.getNumber());
		}
		
		return ret;
	}
	
	public boolean isBlockValid(int column, int row) {
        boolean ret = true;
        
        Cell[] blockCells = getBlock(getBlockIndex(column, row));
        
        Validator val = new Validator();
        
        for (int i = 0; i < blockCells.length; i++) {
            Cell cell = blockCells[i];
            
            if (val.contains(cell.getNumber())) {
                ret = false;
                
                break;
            }
            
            val.add(cell.getNumber());
        }
        
		return ret;
	}
	
	public int getBlockIndex(int column, int row) {
		int rowOffset = row / blockSize;
		int colOffset = column / blockSize;
		
		return (rowOffset * blockSize) + colOffset;
	}
	
	protected Cell[] getBlock(int blockIndex) {
		Cell[] blockCells = new Cell[blockSize * blockSize];
		
		int column = (blockIndex % blockSize) * blockSize;
		int row = (blockIndex / blockSize) * blockSize;
		
		for (int iRow = row; iRow < row + blockSize; iRow++) {
			for (int iCol = column; iCol < column + blockSize; iCol++) {
				blockCells[(iRow - row) * blockSize + (iCol - column)] = cells[iCol][iRow];
			}
		}
		
		return blockCells;
	}

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Grid)) {
            return false;
        }
        Grid rhs = (Grid) object;
        return new EqualsBuilder().append(this.cells, rhs.cells).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1046861843, -874959259).append(this.cells)
                .toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer b = new StringBuffer("\r\n");
        
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                b.append(cells[column][row].getNumber());
            }
            b.append("\r\n");
        }
        
        return b.toString();
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getGridSize() {
        return gridSize;
    }
}
