package in.swarnavo.airbnb.strategy;

import in.swarnavo.airbnb.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PricingService {
    public BigDecimal calculateDynamicPricing(Inventory inventory) {
        PriceStrategy pricingStrategy = new BasePricingStrategy();

        // apply the additional strategy
        pricingStrategy = new SurgePricingStrategy(pricingStrategy);
        pricingStrategy = new OccupancyPricingStrategy(pricingStrategy);
        pricingStrategy = new UrgencyPricingStrategy(pricingStrategy);
        pricingStrategy = new HolidayPricingStrategy(pricingStrategy);

        return pricingStrategy.calculatePrice(inventory);
    }
}
