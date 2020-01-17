package design.chain;

public class HandlerC extends Handler{
    @Override
    protected Level getHandlerLevel() {
        return new Level(3);
    }

    @Override
    public Response echo(Request request) {
        System.out.println("C来处理 levle = 3");
        return new Response("C ->success");
    }
}
