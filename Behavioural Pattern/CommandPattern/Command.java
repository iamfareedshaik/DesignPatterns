interface Command{
    void execute();
}

class Light {
    public void turnOn(){
        System.out.print("Light is on");
    }

    public void turnOff(){
        System.out.print("Light is off");
    }
}

class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}


class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

class LightSwitchApp {
    public static void main(String[] args) {
        Light light = new Light();

        Command turnOnCommand = new TurnOnLightCommand(light);
        Command turnOffCommand = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnCommand);
        remote.pressButton(); 

        remote.setCommand(turnOffCommand);
        remote.pressButton(); 
    }
}
