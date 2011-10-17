package com.nilswinkler.jsudoku.ui;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.nilswinkler.jsudoku.data.Cell;

public class SudokuGridField extends JTextField {

    private static final long serialVersionUID = 6769529361751024574L;
    private final Cell cell;
    private NumberDocument doc;

    public SudokuGridField(Cell cell) {
        this.cell = cell;
        
        doc = new NumberDocument();
        this.setDocument(doc);

        setHorizontalAlignment(JTextField.CENTER);
        if (cell.getNumber() > 0) {
            setText(String.valueOf(cell.getNumber()));
        }

        if (cell.isFixed()) {
            setEditable(false);
        }
        
        doc.addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent arg0) {
                editDoc();
            }

            public void insertUpdate(DocumentEvent arg0) {
                editDoc();
            }

            public void removeUpdate(DocumentEvent arg0) {
                editDoc();
            }
        });
    }

    private class NumberDocument extends PlainDocument {
        private static final long serialVersionUID = -5052729788660679935L;

        public void insertString(int offset, String stringToInsert, AttributeSet attributes) throws BadLocationException {
            int val = 0;
            
            try {
                val = Integer.parseInt(stringToInsert);
            }
            catch (NumberFormatException e) {
                return;
            }

            if (getLength() == 0 && val > 0 && val < 10) {
                super.insertString(offset, stringToInsert, attributes);
            }
        }
    }

    public void editDoc() {
        if (!cell.isFixed()) {
            try {
                cell.setNumber(Integer.parseInt(getText()));
            }
            catch (NumberFormatException ex) {
                cell.setNumber(0);
            }
        }
    }
}
