/**
 * 
 */
package com.nilswinkler.jsudoku.ui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.nilswinkler.jsudoku.data.Grid;
import com.nilswinkler.jsudoku.file.Reader;
import com.nilswinkler.jsudoku.solver.Solver;

/**
 * @author nils
 *
 */
public class SudokuFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 6695625595599415970L;
    protected Grid grid;
    protected SudokuGrid sudokuGrid;

    /**
     * @throws HeadlessException
     * @throws IOException 
     */
    public SudokuFrame() throws HeadlessException, IOException {
        super("JSudoku");
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initMenu();
        
        URL fileUrl = this.getClass().getClassLoader().getResource("easy.txt");
        
        grid = Reader.read(fileUrl.getFile());
        sudokuGrid = new SudokuGrid(grid);
        getContentPane().add(sudokuGrid);
    }
    
    protected void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        menuBar.add(fileMenu);
        
        JMenuItem fileNewMenuItem = fileMenu.add(new JMenuItem("New", 'N'));
        fileNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        fileNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGrid();
            }
        });
        
        JMenuItem fileOpenMenuItem = fileMenu.add(new JMenuItem("Open", 'O'));
        fileOpenMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        fileOpenMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadGrid();
            }
        });
        
        JMenuItem fileSaveMenuItem = fileMenu.add(new JMenuItem("Save", 'S'));
        fileSaveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        fileSaveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveGrid();
            }
        });
        
        JMenuItem fileSolveMenuItem = fileMenu.add(new JMenuItem("Solve", 'L'));
        fileSolveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        fileSolveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveGrid();
            }
        });
        
        fileMenu.addSeparator();
        JMenuItem fileExitMenuItem = fileMenu.add(new JMenuItem("Exit", 'X'));
    }
    
    protected void newGrid() {
        // FIXME Grid size should be dynamic
        grid = new Grid(9);
        
        showNewGrid(grid);
    }
    
    protected void loadGrid() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Grid newGrid;
            try {
                newGrid = Reader.read(fileChooser.getSelectedFile().getAbsolutePath());
                
                showNewGrid(newGrid);
            } catch (IOException e) {
                // FIXME Error handling
                e.printStackTrace();
            }
        }
    }
    
    protected void showNewGrid(Grid newGrid) {
        getContentPane().remove(sudokuGrid);

        grid = newGrid;
        
        sudokuGrid = new SudokuGrid(grid);
        
        getContentPane().add(sudokuGrid);
        
        validate();
    }
    
    protected void solveGrid() {
        Solver solver = new Solver();
        
        boolean solved = solver.solve(grid, 0, 0);    
        
        System.out.println("Solved: " + solved);
        
        sudokuGrid.repaint();
    }
    
    protected void saveGrid() {
        
    }
}
