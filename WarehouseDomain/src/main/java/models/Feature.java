package models;

import core.BusinessRuleValidationException;
import core.Entity;
import rules.StringNotNullOrEmptyRule;

public class Feature extends Entity {

    private String name;
    private String value;

    public Feature(String name, String value) throws BusinessRuleValidationException {
        checkRule(new StringNotNullOrEmptyRule(name,"Feature's name"));
        this.name = name;
        checkRule(new StringNotNullOrEmptyRule(name,"Feature's value"));
        this.value = value;
    }
}
