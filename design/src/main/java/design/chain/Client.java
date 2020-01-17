package design.chain;

public class Client {


    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();
        HandlerC handlerC = new HandlerC();
        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerC);

        Request request = new Request();
        handlerA.handlerMessage(request);
    }
}
