interface BugHandler{
    void handleBug();
}

class Bug{
    private boolean valid;
    private boolean assign;

    public Bug(boolean valid, boolean assign){
        this.valid = valid;
        this.assign = assign;
    }

    public boolean isValid(){
        return isValid;
    }

    public String move(){
        return "moved to next handler";
    }
}


public class BugValidator implements BugHandler{
    private Bug nexthanlder;

    public BugValidator(Bug nexthanlder){
        this.nexthanlder = nexthanlder;
    }
    public void handleBug(){
        if(nexthanlder.isValid){
            System.out.print("Bug is valid");
            System.out.print("processing bug");
        }else{
            nexthanlder.move();
        }
    }
}

class ChainOfResponsibility{
    public static void main(String args[]){
        Bug bug = new Bug();
        bug.isValid = true;
        new BugValidator(bug).handleBug();
    }
}