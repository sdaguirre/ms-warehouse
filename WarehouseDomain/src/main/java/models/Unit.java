package models;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import rules.StringNotNullOrEmptyRule;

public class Unit extends AggregateRoot {

    private String name;
    private boolean has_decimal;
    private boolean round_value;

    public Unit(String name, boolean has_decimal, boolean round_value) throws BusinessRuleValidationException {
        /*if (value < 0)
            throw new IllegalArgumentException("Value cannot be lower than 0");
        this.value = value;*/
        checkRule(new StringNotNullOrEmptyRule(name,"Unit name"));
        this.name=name;
        this.has_decimal = has_decimal;
        this.round_value = round_value;
    }

    public double checkUnit(double value){
        if (!has_decimal)
            return (int) value;
        if (round_value)
            return Math.round(value);
        return value;
    }

    public String getName() {
        return name;
    }

    public boolean isHas_decimal() {
        return has_decimal;
    }

    public boolean isRound_value() {
        return round_value;
    }

    public void setHas_decimal(boolean has_decimal) {
        this.has_decimal = has_decimal;
    }

    public void setRound_value(boolean round_value) {
        this.round_value = round_value;
    }
}
