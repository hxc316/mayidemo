package design.chain;

public class HandlerA extends Handler{
    @Override
    protected Level getHandlerLevel() {
        return new Level(1);
    }

    @Override
    public Response echo(Request request) {
        System.out.println("A来处理 level = 1");
        return new Response("A ->success");
    }
}
