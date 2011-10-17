package com.nilswinkler.jsudoku.file;

import java.net.URL;

import junit.framework.TestCase;

import com.nilswinkler.jsudoku.data.Cell;
import com.nilswinkler.jsudoku.data.Grid;

public class TestReader extends TestCase {

    /*
     * Test method for 'com.nilswinkler.jsudoku.file.Reader.read(String)'
     */
    public void testRead() throws Exception {
        Grid g = new Grid(9);
        
        /*    012345678
            0 4 78   9 
            1  5 1 4   
            2    7 54 2
            3   9 438  
            4 82  6  57
            5   327 9  
            6 6 14 2   
            7    6 7 8 
            8  8   96 1
         */
        g.setCell(0, 0, new Cell(4, true));
        g.setCell(2, 0, new Cell(7, true));
        g.setCell(3, 0, new Cell(8, true));
        g.setCell(7, 0, new Cell(9, true));
        
        g.setCell(1, 1, new Cell(5, true));
        g.setCell(3, 1, new Cell(1, true));
        g.setCell(5, 1, new Cell(4, true));
        
        g.setCell(3, 2, new Cell(7, true));
        g.setCell(5, 2, new Cell(5, true));
        g.setCell(6, 2, new Cell(4, true));
        g.setCell(8, 2, new Cell(2, true));
        
        g.setCell(2, 3, new Cell(9, true));
        g.setCell(4, 3, new Cell(4, true));
        g.setCell(5, 3, new Cell(3, true));
        g.setCell(6, 3, new Cell(8, true));
        
        g.setCell(0, 4, new Cell(8, true));
        g.setCell(1, 4, new Cell(2, true));
        g.setCell(4, 4, new Cell(6, true));
        g.setCell(7, 4, new Cell(5, true));
        g.setCell(8, 4, new Cell(7, true));
        
        g.setCell(2, 5, new Cell(3, true));
        g.setCell(3, 5, new Cell(2, true));
        g.setCell(4, 5, new Cell(7, true));
        g.setCell(6, 5, new Cell(9, true));
        
        g.setCell(0, 6, new Cell(6, true));
        g.setCell(2, 6, new Cell(1, true));
        g.setCell(3, 6, new Cell(4, true));
        g.setCell(5, 6, new Cell(2, true));
        
        g.setCell(3, 7, new Cell(6, true));
        g.setCell(5, 7, new Cell(7, true));
        g.setCell(7, 7, new Cell(8, true));
        
        g.setCell(1, 8, new Cell(8, true));
        g.setCell(5, 8, new Cell(9, true));
        g.setCell(6, 8, new Cell(6, true));
        g.setCell(8, 8, new Cell(1, true));
        
        URL fileUrl = this.getClass().getClassLoader().getResource("easy.txt");
        
        assertNotNull(fileUrl);
        
        Grid gridLoaded = Reader.read(fileUrl.getFile());
        
        assertNotNull(gridLoaded);
        
        assertEquals(g, gridLoaded);
    }
}
