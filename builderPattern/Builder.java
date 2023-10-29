class Computer{
    private String cpu;
    private int ram;
    private int storage;

    public Computer(String cpu, int ram, int storage){
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }
}

interface Config{
    Config setCpu(String cpu);
    Config setRam(int ram);
    Config setStorage(int storage);
    Computer build();
}

class ComputerSetup implements Config{
    private String cpu;
    private int ram;
    private int storage;

    public Computer build(){
        return new Computer(cpu, ram, storage);
    }
    // here in all methods we are returning this because it will in chainning as well as for optional fields
    // till which method is called till there object will holds its properties

    public Config setCpu(String cpu){
        this.cpu = cpu;
        return this; 
    }

    public Config setRam(int ram){
        this.ram = ram;
        return this;
    }

    public Config setStorage(int storage){
        this.storage = storage;
        return this; 
    }
    
}

class Laptop{
    private Config config;

    public Laptop(Config config){
        this.config = config;
    }

    public Computer getLaptopInstance(){
        return config.setCpu("intel").setRam(20).setStorage(100).build();
    }
}

class Builder{
    public static void main(String args[]){
        Laptop laptop = new Laptop(new ComputerSetup());
        Computer computerLap = laptop.getLaptopInstance();
        System.out.print(computerLap instanceof Computer);
    }
}