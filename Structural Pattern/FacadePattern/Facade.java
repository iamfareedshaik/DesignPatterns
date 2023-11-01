class Engine{
    public void start(){
        System.out.println("started Engine");
    }

    public void stop(){
        System.out.println("Stopped Engine");
    }
}

class FuleInjected{
    public void injected(){
        System.out.println("fuel injected");
    }
}

class FacadeInterface{
    private Engine engine;
    private FuleInjected inject;

    public FacadeInterface(){
        engine = new Engine();
        inject = new FuleInjected();

    }

    public void startCar(){
        engine.start();
        inject.injected();
    }

    public void stopCar(){
        engine.stop();
    }

}

class Facade{
    public static void main(String args[]){
        FacadeInterface carInterface = new FacadeInterface();
        carInterface.startCar();
        carInterface.stopCar();
    }
}