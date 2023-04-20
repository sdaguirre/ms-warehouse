package rules;

import core.BusinessRule;

public class StringNotNullOrEmptyRule implements BusinessRule {

    private final String value;
    private final String nameValue;

    public StringNotNullOrEmptyRule(String value) {
        this.value = value;
        this.nameValue = "String";
    }

    public StringNotNullOrEmptyRule(String value, String nameValue) {
        this.value = value;
        this.nameValue = nameValue;
    }

    @Override
    public boolean isValid() {
        return value != null || !value.isEmpty();
    }

    @Override
    public String getMessage() {
        return nameValue + " can not be null";
    }
}
