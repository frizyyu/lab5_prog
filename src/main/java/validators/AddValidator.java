package validators;

import com.google.common.base.Splitter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import supportive.*;
import helpers.*;

import java.time.ZonedDateTime;
import java.util.*;

public class AddValidator implements ValidatorInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    @Override
    public boolean validationCheck(String[] str) {
        if (str.length == 1){
            return true;
        }

        SimpleValidationWithElement check = new SimpleValidationWithElement();
        return check.validate(str);
    }

    @Override
    public String parameterCheck(String[] str) {
        if (str.length != 1)
            return str[1];
        return "";
    }
}
