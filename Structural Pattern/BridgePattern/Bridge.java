interface Color{
    void applyColor();
}

class RedColor implements Color{
    public void applyColor(){
        System.out.print("applying red color");
    }
}

class GreenColor implements Color{
    public void applyColor(){
        System.out.print("applying Green Color");
    }
}

abstract class Shape{
    protected Color color;

    public Shape(Color color){
        this.color = color;
    }

    public abstract void draw();
}


class Circle extends Shape{
    public Circle(Color color){
        super(color);
    }

    public void draw(){
        System.out.print("Drawing a circle");
        color.applyColor();
    }
}

class Square extends Shape{
    public Square(Color color){
        super(color);
    }

    public void draw(){
        System.out.print("drawing a square");
        color.applyColor();
    }
}

class Bridge{
    public static void main(String args[]){
        Color color = new RedColor();
        Shape circle = new Circle(color);
        circle.draw();
        
    }
}