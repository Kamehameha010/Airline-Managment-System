package com.cr.tools.component.table;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CustomCellRender implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component render = DEFAULT_RENDER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                column);
        
        
        render.setFont(new Font("Agency FB", Font.BOLD, 14));
        render.setForeground(new Color(0,0,0));

        return render;
    }

}
