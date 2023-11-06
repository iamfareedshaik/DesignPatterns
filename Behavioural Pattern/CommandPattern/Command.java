interface Command{
    void execute();
}

public class Light {
    public void turnOn(){
        System.out.print("Light is on");
    }

    public void turnOff(){
        System.out.print("Light is off");
    }
}

public class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

public class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}


public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class LightSwitchApp {
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
