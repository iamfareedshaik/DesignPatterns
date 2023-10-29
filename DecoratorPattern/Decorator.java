interface Text{
    String getContent();
}

class PlainText implements Text{
    private String content;

    public PlainText(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}


class BoldDecorator implements Text{
    private Text text;
    public BoldDecorator(Text text){
        this.text = text;
    }

    public String getContent(){
        return "Bold-" + text.getContent();
    }
}

class ItlaicDecorator implements Text{
    private Text text;
    public ItlaicDecorator(Text text){
        this.text = text;
    }

    public String getContent(){
        return "Italic-" + text.getContent();
    }
}

class Decorator{
    public static void main(String args[]){
        Text text = new ItlaicDecorator(new BoldDecorator(new PlainText("Hello World")));
        System.out.print(text.getContent());
    }
}