package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Dog;

public class DogListCellRenderer implements ListCellRenderer<Dog> {
	
	private DefaultListCellRenderer dfcr;

	
	public Component getListCellRendererComponent(JList<? extends Dog> list, Dog value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		dfcr = new DefaultListCellRenderer();
	    return dfcr.getListCellRendererComponent(list, value.getName(), index,
	                                             isSelected, cellHasFocus);
	}

}
