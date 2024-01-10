package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {

    public boolean isNumber(String numberStr, Pattern pattern) {
        Matcher matcher = pattern.matcher(numberStr);
        return matcher.find();
    }
}

