package validators;

import helpers.SimpleValidator;

public class AverageOfAlbumsCountValidator implements ValidatorInterface {
    /**
     *
     *
     * @author frizyyu
     * @version 1.0
     */
    SimpleValidator valid = new SimpleValidator();
    @Override
    public boolean validationCheck(String[] str) {
        return this.valid.validate(str);
    }

    @Override
    public String parameterCheck(String[] str) {
        return this.valid.paramCheck(str);
    }
}
