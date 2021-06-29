package com.cr.tools.component.combobox;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.cr.model.Rol;

public class RolListCellRender extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {

        if (value instanceof Rol) {
            value = ((Rol) value).getName();
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    }
}
