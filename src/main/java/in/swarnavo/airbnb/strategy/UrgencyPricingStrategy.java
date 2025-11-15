package in.swarnavo.airbnb.strategy;

import in.swarnavo.airbnb.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class UrgencyPricingStrategy implements PriceStrategy {

    private final PriceStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapped.calculatePrice(inventory);
        LocalDateTime today = LocalDateTime.now();
        if(!inventory.getDate().isBefore(ChronoLocalDate.from(today)) && inventory.getDate().isBefore(ChronoLocalDate.from(today.plusDays(7)))) {
            price = price.multiply(BigDecimal.valueOf(1.15));
        }
        return price;
    }
}
