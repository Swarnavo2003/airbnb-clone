package in.swarnavo.airbnb.strategy;

import in.swarnavo.airbnb.entity.Inventory;

import java.math.BigDecimal;

public class BasePricingStrategy implements PriceStrategy {
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
