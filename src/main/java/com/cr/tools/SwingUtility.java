package com.cr.tools;

import java.awt.Container;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import com.cr.helper.IMethodHelper;
import com.cr.helper.MethodHelper;

public class SwingUtility<T> {

    IMethodHelper<T> _methodHelper;

    public SwingUtility() {
        _methodHelper = new MethodHelper<T>();
    }

    public Map<String, Object> getDataComponents(final Container container) {

        var dataComponents = new HashMap<String, Object>();

        for (var component : container.getComponents()) {

            if (component instanceof JTextComponent) {
                dataComponents.put(component.getName(), ((JTextComponent) component).getText().trim());
            }
            if (component instanceof JComboBox) {
                dataComponents.put(component.getName(), ((JComboBox) component).getSelectedItem());
            }
        }
        return dataComponents;
    }

    public T intanceObject(Class<T> cls, Map<String, Object> params)
            throws NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalAccessException, IllegalArgumentException, IntrospectionException {
        var obj = cls.getDeclaredConstructor().newInstance();
        for (var param : params.entrySet()) {
            _methodHelper.invokeSetter(obj, param.getKey(), validString((String) param.getValue()));
        }
        return obj;
    }

    private Object validString(String str) {
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        } else if (isBoolean(str)) {
            return Boolean.parseBoolean(str);
        }
        return str;
    }

    private boolean isNumeric(String str) {
        Pattern regex = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (str == null) {
            return false;
        }
        return regex.matcher(str).matches();
    }

    private boolean isBoolean(String str) {
        Pattern regex = Pattern.compile("(true|false)");
        if (str == null) {
            return false;
        }
        return regex.matcher(str).matches();
    }
}
