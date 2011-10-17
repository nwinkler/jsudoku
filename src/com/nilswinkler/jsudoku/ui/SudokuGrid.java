/**
 * 
 */
package com.nilswinkler.jsudoku.ui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;

import com.nilswinkler.jsudoku.data.Grid;

/**
 * @author nils
 *
 */
public class SudokuGrid extends JComponent {

    /**
     * 
     */
    private static final long serialVersionUID = 3937184897944919385L;
    private final int blockSize;
    private final int gridSize;

    public SudokuGrid(Grid grid) {
        this.blockSize = grid.getBlockSize();
        this.gridSize = grid.getGridSize();
        
        setLayout(new GridLayout(gridSize, gridSize, 5, 5));
        
        Font fieldFont = new Font("monospaced", Font.BOLD, 24);
        
        for (int col = 0; col < gridSize; col++) {
            for (int row = 0; row < gridSize; row++) {
                SudokuGridField gridField = new SudokuGridField(grid.getCell(col, row));
                gridField.setFont(fieldFont);
                add(gridField);
            }
        }
    }
}
