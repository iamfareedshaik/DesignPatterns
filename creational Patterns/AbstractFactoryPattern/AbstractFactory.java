interface Button{
    public void createdButton();
}

interface Checkbox{
    public void createdCheckbox();
}

class ButtonWidget implements Button{
    public void createdButton(){
        System.out.println("created button");
    }
}

class CheckboxWidget implements Checkbox{
    public void createdCheckbox(){
        System.out.println("created checkbox");
    }
}


interface Widget{
    public Button createbuttonW();
    public Checkbox createCheckboxW();
}

class macos implements Widget{
    public Button createbuttonW(){
        return new ButtonWidget();
    }

    public Checkbox createCheckboxW(){
        return new CheckboxWidget();
    }
}

class AbstractFactory{

    public static void main(String args[]){
        Widget widget = new macos();
        widget.createbuttonW().createdButton();
        widget.createCheckboxW().createdCheckbox();
    }
}