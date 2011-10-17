package com.nilswinkler.jsudoku.data;

import junit.framework.TestCase;

public class TestGrid extends TestCase {

	/*
	 * Test method for 'com.nilswinkler.jsudoku.data.Grid.isColumnValid(int)'
	 */
	public void testIsColumnValid() {
		Grid g = new Grid(9);
		
		g.setCell(0, 0, new Cell(1, false));
		assertTrue(g.isColumnValid(0));
		
		g.setCell(0, 1, new Cell(2, false));
		assertTrue(g.isColumnValid(0));
		
		g.setCell(0, 2, new Cell(2, false));
		assertFalse(g.isColumnValid(0));
	}

	/*
	 * Test method for 'com.nilswinkler.jsudoku.data.Grid.isRowValid(int)'
	 */
	public void testIsRowValid() {
		Grid g = new Grid(9);
		
		g.setCell(0, 0, new Cell(1, false));
		assertTrue(g.isRowValid(0));
		
		g.setCell(1, 0, new Cell(2, false));
		assertTrue(g.isRowValid(0));
		
		g.setCell(2, 0, new Cell(2, false));
		assertFalse(g.isRowValid(0));
	}
	
	public void testGetBlock() {
		Grid g = new Grid(9);
		
		g.setCell(0, 0, new Cell(1, false));
		g.setCell(1, 0, new Cell(2, false));
		g.setCell(2, 0, new Cell(3, false));
		
		g.setCell(0, 1, new Cell(4, false));
		g.setCell(1, 1, new Cell(5, false));
		g.setCell(2, 1, new Cell(6, false));
		
		g.setCell(0, 2, new Cell(7, false));
		g.setCell(1, 2, new Cell(8, false));
		g.setCell(2, 2, new Cell(9, false));
		
		Cell cells[] = g.getBlock(0);
		
		assertNotNull(cells);
		assertEquals(9, cells.length);
		
		assertEquals(1, cells[0].getNumber());
		assertEquals(2, cells[1].getNumber());
		assertEquals(3, cells[2].getNumber());
		
		assertEquals(4, cells[3].getNumber());
		assertEquals(5, cells[4].getNumber());
		assertEquals(6, cells[5].getNumber());
		
		assertEquals(7, cells[6].getNumber());
		assertEquals(8, cells[7].getNumber());
		assertEquals(9, cells[8].getNumber());
	}
	
	public void testGetBlock2() {
		Grid g = new Grid(9);
		
		g.setCell(3, 6, new Cell(1, false));
		g.setCell(4, 6, new Cell(2, false));
		g.setCell(5, 6, new Cell(3, false));
		
		g.setCell(3, 7, new Cell(4, false));
		g.setCell(4, 7, new Cell(5, false));
		g.setCell(5, 7, new Cell(6, false));
		
		g.setCell(3, 8, new Cell(7, false));
		g.setCell(4, 8, new Cell(8, false));
		g.setCell(5, 8, new Cell(9, false));
		
		Cell cells[] = g.getBlock(7);
		
		assertNotNull(cells);
		assertEquals(9, cells.length);
		
		assertEquals(1, cells[0].getNumber());
		assertEquals(2, cells[1].getNumber());
		assertEquals(3, cells[2].getNumber());
		
		assertEquals(4, cells[3].getNumber());
		assertEquals(5, cells[4].getNumber());
		assertEquals(6, cells[5].getNumber());
		
		assertEquals(7, cells[6].getNumber());
		assertEquals(8, cells[7].getNumber());
		assertEquals(9, cells[8].getNumber());
	}
    
    public void testIsBlockValid() {
        Grid g = new Grid(9);
        
        g.setCell(3, 6, new Cell(1, false));
        assertTrue(g.isBlockValid(4, 7));
        
        g.setCell(4, 7, new Cell(2, false));
        assertTrue(g.isBlockValid(4, 7));
        
        g.setCell(5, 7, new Cell(2, false));
        assertFalse(g.isBlockValid(4, 7));
    }

	public void testGetBlockIndex() {
		Grid g = new Grid(9);
		
		assertEquals(0, g.getBlockIndex(0, 0));
		assertEquals(0, g.getBlockIndex(1, 0));
		assertEquals(0, g.getBlockIndex(2, 0));
		assertEquals(0, g.getBlockIndex(0, 1));
		assertEquals(0, g.getBlockIndex(1, 1));
		assertEquals(0, g.getBlockIndex(2, 1));
		assertEquals(0, g.getBlockIndex(0, 2));
		assertEquals(0, g.getBlockIndex(1, 2));
		assertEquals(0, g.getBlockIndex(2, 2));
		
		assertEquals(1, g.getBlockIndex(3, 0));
		assertEquals(1, g.getBlockIndex(4, 0));
		assertEquals(1, g.getBlockIndex(5, 0));
		assertEquals(1, g.getBlockIndex(3, 1));
		assertEquals(1, g.getBlockIndex(4, 1));
		assertEquals(1, g.getBlockIndex(5, 1));
		assertEquals(1, g.getBlockIndex(3, 2));
		assertEquals(1, g.getBlockIndex(4, 2));
		assertEquals(1, g.getBlockIndex(5, 2));
		
		assertEquals(2, g.getBlockIndex(6, 0));
		assertEquals(2, g.getBlockIndex(7, 0));
		assertEquals(2, g.getBlockIndex(8, 0));
		assertEquals(2, g.getBlockIndex(6, 1));
		assertEquals(2, g.getBlockIndex(7, 1));
		assertEquals(2, g.getBlockIndex(8, 1));
		assertEquals(2, g.getBlockIndex(6, 2));
		assertEquals(2, g.getBlockIndex(7, 2));
		assertEquals(2, g.getBlockIndex(8, 2));
		
		assertEquals(3, g.getBlockIndex(0, 3));
		assertEquals(3, g.getBlockIndex(1, 4));
		assertEquals(3, g.getBlockIndex(2, 5));
		assertEquals(3, g.getBlockIndex(0, 3));
		assertEquals(3, g.getBlockIndex(1, 4));
		assertEquals(3, g.getBlockIndex(2, 5));
		assertEquals(3, g.getBlockIndex(0, 3));
		assertEquals(3, g.getBlockIndex(1, 4));
		assertEquals(3, g.getBlockIndex(2, 5));
		
		assertEquals(4, g.getBlockIndex(3, 3));
		assertEquals(4, g.getBlockIndex(4, 4));
		assertEquals(4, g.getBlockIndex(5, 5));
		assertEquals(4, g.getBlockIndex(3, 3));
		assertEquals(4, g.getBlockIndex(4, 4));
		assertEquals(4, g.getBlockIndex(5, 5));
		assertEquals(4, g.getBlockIndex(3, 3));
		assertEquals(4, g.getBlockIndex(4, 4));
		assertEquals(4, g.getBlockIndex(5, 5));
		
		assertEquals(5, g.getBlockIndex(6, 3));
		assertEquals(5, g.getBlockIndex(7, 4));
		assertEquals(5, g.getBlockIndex(8, 5));
		assertEquals(5, g.getBlockIndex(6, 3));
		assertEquals(5, g.getBlockIndex(7, 4));
		assertEquals(5, g.getBlockIndex(8, 5));
		assertEquals(5, g.getBlockIndex(6, 3));
		assertEquals(5, g.getBlockIndex(7, 4));
		assertEquals(5, g.getBlockIndex(8, 5));
		
		assertEquals(6, g.getBlockIndex(0, 6));
		assertEquals(6, g.getBlockIndex(1, 7));
		assertEquals(6, g.getBlockIndex(2, 8));
		assertEquals(6, g.getBlockIndex(0, 6));
		assertEquals(6, g.getBlockIndex(1, 7));
		assertEquals(6, g.getBlockIndex(2, 8));
		assertEquals(6, g.getBlockIndex(0, 6));
		assertEquals(6, g.getBlockIndex(1, 7));
		assertEquals(6, g.getBlockIndex(2, 8));
		
		assertEquals(7, g.getBlockIndex(3, 6));
		assertEquals(7, g.getBlockIndex(4, 7));
		assertEquals(7, g.getBlockIndex(5, 8));
		assertEquals(7, g.getBlockIndex(3, 6));
		assertEquals(7, g.getBlockIndex(4, 7));
		assertEquals(7, g.getBlockIndex(5, 8));
		assertEquals(7, g.getBlockIndex(3, 6));
		assertEquals(7, g.getBlockIndex(4, 7));
		assertEquals(7, g.getBlockIndex(5, 8));
		
		assertEquals(8, g.getBlockIndex(6, 6));
		assertEquals(8, g.getBlockIndex(7, 7));
		assertEquals(8, g.getBlockIndex(8, 8));
		assertEquals(8, g.getBlockIndex(6, 6));
		assertEquals(8, g.getBlockIndex(7, 7));
		assertEquals(8, g.getBlockIndex(8, 8));
		assertEquals(8, g.getBlockIndex(6, 6));
		assertEquals(8, g.getBlockIndex(7, 7));
		assertEquals(8, g.getBlockIndex(8, 8));
	}
}
