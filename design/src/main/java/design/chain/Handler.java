package design.chain;

public abstract class Handler {

    private Handler nextHandler;

    public Response handlerMessage(Request request){
        if(this.getHandlerLevel().getLevel() == request.getLevel().getLevel()){
            return this.echo(request);
        }
        if(this.nextHandler != null){
            return this.nextHandler.handlerMessage(request);
        }
        return null;
    }

    protected abstract Level getHandlerLevel();

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    protected abstract Response echo(Request request);

}
