package com.nilswinkler.jsudoku.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.nilswinkler.jsudoku.data.Cell;
import com.nilswinkler.jsudoku.data.Grid;

public class Reader {
    public static Grid read(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        int gridSize = 0;
        String firstLine = reader.readLine();
        if (firstLine != null) {
            try {
                gridSize = Integer.valueOf(firstLine).intValue();
            }
            catch (NumberFormatException e) {
                // TODO Handle error here, throw exception
            }
        }
        
        Grid g = new Grid(gridSize);
        
        for (int row = 0; row < g.getGridSize(); row++) {
            String line = reader.readLine();
            
            if (line == null) {
                break;
            }
            
            for (int column = 0; column < g.getGridSize() && column < line.length(); column++) {
                char currentChar = line.charAt(column);
                
                int number = 0;
                
                try {
                    number = Integer.parseInt(String.valueOf(currentChar));
                }
                catch (NumberFormatException ignore) {
                }
                
                if (number != 0) {
                    g.setCell(column, row, new Cell(number, true));
                }
            }
        }
        
        reader.close();
        
        return g;
    }
}
