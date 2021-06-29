package com.cr.tools.component.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {

    private List<?> rows;
    private String[] columnNames;

    public CustomTableModel(List<?> rows, String[] columnNames) {
        this.rows = rows;
        this.columnNames = columnNames;     
    }

    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    public String getColumnName​(int column){
        return columnNames[column];
    }
    public Object getSelectedRow(int row) {
        return this.rows.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    
}

