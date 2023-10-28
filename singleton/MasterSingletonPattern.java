class SingletonPattern{
    private static SingletonPattern instance;

    private SingletonPattern(){

    }

    public static SingletonPattern getInstance(){
        if(instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }
}

class MasterSingletonPattern{
    public static void main(String args[]){
        SingletonPattern instance = SingletonPattern.getInstance();
        SingletonPattern instance1 = SingletonPattern.getInstance();
        //SingletonPattern instance = new SingletonPattern() // Constructor is private where object will unable to create
        if(instance == instance1){
            System.out.print("Same instance");
        }
    }
}