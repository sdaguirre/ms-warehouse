package models;

import core.AggregateRoot;
import core.BusinessRuleValidationException;
import rules.NotNullRule;
import rules.StringNotNullOrEmptyRule;

import java.util.UUID;

public class Inventory extends AggregateRoot {

    private UUID article_id;
    private UUID warehouse_id;
    private double quantity;
    private Unit unit;

    public Inventory(UUID article_id, UUID warehouse_id, int quantity, Unit unit) throws BusinessRuleValidationException {
        checkRule(new NotNullRule(article_id));
        checkRule(new NotNullRule(warehouse_id));
        this.article_id = article_id;
        this.warehouse_id = warehouse_id;
        this.quantity = unit.checkUnit(quantity);
    }

    public void addStock(int quantity) {
        this.quantity += unit.checkUnit(quantity);
    }

    public void removeStock(int quantity) {
        this.quantity -= unit.checkUnit(quantity);
    }


    public UUID getArticle_id() {
        return article_id;
    }

    public UUID getWarehouse_id() {
        return warehouse_id;
    }

    public double getQuantity() {
        return quantity;
    }
}
