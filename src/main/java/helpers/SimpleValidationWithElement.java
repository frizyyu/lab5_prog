package helpers;

import java.util.Objects;

public class SimpleValidationWithElement {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    public boolean validate(String[] str){
        if (str.length == 2 && Objects.equals(str[1], "-h"))
            return true;
        else if (str.length == 2){
            ElementValidCheck check = new ElementValidCheck();
            return check.elementValidCheck(str);
        }
        System.out.println("Missing argument");
        return false;
    }
}
