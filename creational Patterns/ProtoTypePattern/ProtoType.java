interface Computer{
    Computer clone();
    void display();
}

class Window implements Computer{
    public void display(){
        System.out.print("windows system")
    }
    public Computer clone(){
        return new Windows(); // here we can add custom logic   
    }
}

class ProtoType{
    public static void main(String args[]){
        Window window = new Windows();
        Window window1 = window.clone();
        System.out.print(window == window1);
    }
}