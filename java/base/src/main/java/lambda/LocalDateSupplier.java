package lambda;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * @author hk
 */
public class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2020, 1, 1);
    int       n     = -1;

    @Override
    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
