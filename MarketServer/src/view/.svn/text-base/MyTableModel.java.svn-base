package view;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] columnNames;
	Object[][] data;
	
	public MyTableModel(Object[][] data,String[] columnNames)
	{
		this.columnNames=columnNames;
		this.data=data;
	}
	
	public int getColumnCount()   { 
        return   columnNames.length; 
	} 

	public int getRowCount()   { 
		return   data.length; 
	} 

	public  String getColumnName(int col){ 
        return   columnNames[col]; 
	} 

	public  Object  getValueAt(int   row,   int   col)  
	{
        return   data[row][col]; 
	} 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int   c)
	{
        return   getValueAt(0,   c).getClass(); 
	} 
	
	public boolean isCellEditable(int row,int col)
	{
		return false;
	}
	
}
