package action.chain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    private List<Handler> handlers = new ArrayList<>();

    public void  addHandle(Handler handler)
    {
        handlers.add(handler);
    }

    public boolean process(Request request){
        for (Handler handler : this.handlers){
            Boolean rtn = handler.process(request);
            if(rtn != null){
                System.out.println(handler.getClass().getSimpleName() + " " + (rtn ? "通过 " : "拒绝 ") + request.getName() );
                return rtn;
            }
        }

        throw new RuntimeException("Could not handle request: " + request);
    }

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandle(new ManagerHandler());
        handlerChain.addHandle(new CEOHandler());

        handlerChain.process(new Request("alob", BigDecimal.valueOf(10)));
        handlerChain.process(new Request("blob", BigDecimal.valueOf(100)));
        handlerChain.process(new Request("clob", BigDecimal.valueOf(5000)));
        handlerChain.process(new Request("dlob", BigDecimal.valueOf(100000)));
    }
}
