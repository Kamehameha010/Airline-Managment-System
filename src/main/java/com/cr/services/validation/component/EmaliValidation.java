package com.cr.services.validation.component;

import java.util.regex.Pattern;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class EmaliValidation extends InputVerifier {

    @Override
    public boolean verify(JComponent component) {
        var pattern = Pattern.compile("^[\\w-\\.]+@\\(gmail|hotmail|outlook)\\.[\\w-]{2,4}$");
        String input = ((JTextField) component).getText();
        var match = pattern.matcher(input);
        return match.matches();
    }

}
