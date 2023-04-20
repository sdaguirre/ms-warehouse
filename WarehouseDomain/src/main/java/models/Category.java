package models;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import rules.StringNotNullOrEmptyRule;

import java.util.UUID;

public class Category extends AggregateRoot {

    private String name;

    public Category(String name) throws BusinessRuleValidationException {
        super();
        checkRule(new StringNotNullOrEmptyRule(name,"Category name"));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
