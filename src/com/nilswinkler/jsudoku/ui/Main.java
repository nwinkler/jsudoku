package com.nilswinkler.jsudoku.ui;

import javax.swing.SwingUtilities;

public class Main {
    private static void createAndShowGui() {
        try {
            SudokuFrame frame = new SudokuFrame();
            
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            };
        });
    }

}
