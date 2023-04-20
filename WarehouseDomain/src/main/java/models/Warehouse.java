package models;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import rules.StringNotNullOrEmptyRule;

public class Warehouse extends AggregateRoot {

    private String name;
    private String location;

    public Warehouse(String name, String location) throws BusinessRuleValidationException {
        super();
        checkRule(new StringNotNullOrEmptyRule(name,"Warehouse name"));
        this.name = name;
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Location can't be null or empty");
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
