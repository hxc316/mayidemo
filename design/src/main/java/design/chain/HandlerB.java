package design.chain;

public class HandlerB extends Handler{
    @Override
    protected Level getHandlerLevel() {
        return new Level(2);
    }

    @Override
    public Response echo(Request request) {
        System.out.println("B来处理 levle = 2");
        return new Response("B ->success");
    }
}
