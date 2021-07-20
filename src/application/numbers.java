package application;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class numbers extends PlainDocument{
	
	private static final long serialVersionUID = 1L;

	public void insertString(int offs,String str, AttributeSet a)throws BadLocationException{
		super.insertString(offs, str.replaceAll("[^0-9]",""), a);
	}
}

