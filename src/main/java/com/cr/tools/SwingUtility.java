package com.cr.tools;

import java.awt.Container;
import java.awt.Component;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import com.cr.helper.IMethodHelper;
import com.cr.helper.MethodHelper;
import com.toedter.calendar.JDateChooser;

public class SwingUtility<T> {

    IMethodHelper<T> _methodHelper;

    public SwingUtility() {
        _methodHelper = new MethodHelper<T>();
    }

    public Map<String, Object> getDataComponents(final Container container) {

        var dataComponents = new HashMap<String, Object>();

        for (var component : container.getComponents()) {
            switch (component.getClass().getName().replaceAll("^([a-z]+\\.){2,}", "")) {
                case "JTextField", "JTextArea", "JPasswordField" -> dataComponents.put(component.getName(),
                        ConvertToTextComponent(component));
                case "JComboBox" -> dataComponents.put(component.getName(), ConvertToJComboBox(component));
                case "JDateChooser" -> dataComponents.put(component.getName(), JDateChooser.class.cast(component).getDate());
            }
        }
        return dataComponents;
    }

    public T intanceObject(Class<T> cls, Map<String, Object> params)
            throws NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalAccessException,
            IllegalArgumentException, IntrospectionException {
        var obj = cls.getDeclaredConstructor().newInstance();
        for (var param : params.entrySet()) {
            _methodHelper.invokeSetter(obj, param.getKey(), checkObject(param.getValue()));
        }
        return obj;
    }

    private Object checkObject(Object value) {
        if (value instanceof String) {
            return validString(value);
        }
        return value;
    }

    private Object validString(Object value) {
        if (isNumeric(value.toString())) {
            return Integer.parseInt(value.toString());
        } else if (isBoolean(value.toString())) {
            return Boolean.parseBoolean(value.toString());
        }
        return value;
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

    private Object ConvertToTextComponent(final Component comp) {
        return JTextComponent.class.cast(comp).getText();
    }

    private Object ConvertToJComboBox(final Component comp) {
        return JComboBox.class.cast(comp).getSelectedItem();
    }
}
