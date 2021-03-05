package action.chain;

import java.math.BigDecimal;

public class CEOHandler implements Handler {
    @Override
    public Boolean process(Request request) {
        if(request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0){
            return false;
        }

        return true;
    }
}
