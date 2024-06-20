package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator {

   public boolean isPattern(String numberStr, Pattern pattern) {
      Matcher matcher = pattern.matcher(numberStr);
      return matcher.find();
   }
}

