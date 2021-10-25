package com.cr.tools.component.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel<T> extends AbstractTableModel {

    private String[] m_names /* = { "ID", "CODE", "NAME", "SOURCE", "DESTINATION", "DATE" } */;

    private List<T> m_data;

    public CustomTableModel(List<T> data, String[] names) {
        m_data = data;
        m_names = names;
    }

    @Override
    public int getRowCount() {
        return m_data.size();
    }

    @Override
    public int getColumnCount() {
        return m_names.length;
    }

    @Override
    public String getColumnName(int column) {
        return m_names[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public T getSelectedRow(int pos) {
        return m_data.get(pos);
    }

}
