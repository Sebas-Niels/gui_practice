package gui;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Member;

public class MemberTableModel extends AbstractTableModel {
	private ArrayList<Member> data;
	private static final String[] COL_NAMES = {"Name", "Email", "Phone"};
	
	public MemberTableModel(ArrayList<Member> data) {
		this.data = data;
		if(this.data == null) {
			this.data = new ArrayList<>();
		}
	}
	
	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Member m = data.get(rowIndex);
		String returnString = "";
		switch(columnIndex) {
			case 0: 
				returnString = m.getName();
				break;
			
			case 1: 
				returnString = "" + m.getEmail();
				break;
				
			case 2: 
				returnString = "" + m.getPhone();
				break;
				
			default: returnString = "<UNKNOWN " + columnIndex + ">";
		}
		return returnString;
	}
	
	public Member getDataAt(int rowIndex) {
		return data.get(rowIndex);
	}
	
	public void setData(ArrayList<Member> data) {
		this.data = data;
		super.fireTableDataChanged();
	}

}
