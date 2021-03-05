package action.chain;

import java.math.BigDecimal;

/**
 * 让多个处理器都有机会处理该请求，直到其中某个处理成功为止
 */
public class Request {
    private final String     name;
    private final BigDecimal amount;

    public Request(String name, BigDecimal amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getAmount()
    {
        return this.amount;
    }
}
