package com.nilswinkler.jsudoku.foo;

import java.io.IOException;
import java.net.URL;

import com.nilswinkler.jsudoku.data.Grid;
import com.nilswinkler.jsudoku.file.Reader;
import com.nilswinkler.jsudoku.solver.Solver;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    URL fileUrl = Main.class.getClassLoader().getResource("evil.txt");
        
        try {
            Grid gridLoaded = Reader.read(fileUrl.getFile());
            
            long start = System.currentTimeMillis();
            
            System.out.println("Solving grid: " + gridLoaded);
            
            Solver solver = new Solver();
            
            boolean solved = solver.solve(gridLoaded, 0, 0);
            
            long end = System.currentTimeMillis();
            
            System.out.println("Solved: " + solved + ", milliseconds: " + (end - start));
            System.out.println("Grid: " + gridLoaded);
        } catch (IOException e) {
            e.printStackTrace();
        }	
    }
}
