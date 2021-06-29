package com.cr.tools.component.combobox;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.cr.model.Plane;

public class PlaneListCellRender extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {

        if (value instanceof Plane) {
            value = ((Plane) value).getName();
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    }
}


