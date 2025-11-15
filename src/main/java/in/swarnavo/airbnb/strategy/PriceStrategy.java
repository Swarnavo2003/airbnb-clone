package in.swarnavo.airbnb.strategy;

import in.swarnavo.airbnb.entity.Inventory;

import java.math.BigDecimal;

public interface PriceStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
