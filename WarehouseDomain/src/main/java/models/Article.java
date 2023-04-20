package models;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import rules.NotNullRule;
import rules.StringNotNullOrEmptyRule;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Article extends AggregateRoot {

    private String name;
    private double cost;
    private UUID unit_id;
    private UUID category_id;
    private List<Feature> features;

    public Article(String name, double cost,UUID unit_id, UUID category_id) throws BusinessRuleValidationException {
        super();
        validateFields(name, cost,unit_id);
        this.name = name;
        this.cost = cost;
        this.unit_id = unit_id;
        if (category_id == null)
            throw new IllegalArgumentException("An article must have a category");
        this.category_id = category_id;
        this.features = new ArrayList<>();
    }

    public void addFeature(String name, String value) throws BusinessRuleValidationException {
        features.add(new Feature(name, value));
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public UUID getCategory_id() {
        return category_id;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public UUID getUnit_id() {
        return unit_id;
    }

    public void validateFields(String name, double cost,UUID unit_id) throws BusinessRuleValidationException {
        checkRule(new StringNotNullOrEmptyRule(name, "Article name"));
        checkRule(new NotNullRule(unit_id));
        if (cost < 0)
            throw new IllegalArgumentException("Cost can't be less than 0");
    }

    public void editInfo(String name, double cost,UUID unit_id) throws BusinessRuleValidationException {
        validateFields(name, cost,unit_id);
        this.name = name;
        this.cost = cost;
    }
}
