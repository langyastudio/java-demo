package action.chain;

public interface Handler {
    Boolean process(Request request);
}