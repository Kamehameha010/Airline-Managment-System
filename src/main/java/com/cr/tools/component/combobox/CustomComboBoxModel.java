package com.cr.tools.component.combobox;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class CustomComboBoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {

    private List<T> items;
    private Object selectedItem;

    public CustomComboBoxModel(List<T> items) {
        this.items = items;
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public T getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selectedItem;
    }

}
