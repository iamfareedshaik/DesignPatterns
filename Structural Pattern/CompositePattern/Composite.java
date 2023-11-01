import java.util.*;
interface FileSystem{
    public void display();
}

class File implements FileSystem{
    private String name;
    public File(String name){
        this.name = name;
    }
    public void display(){
        System.out.println("Displaying file" + name);
    }
}


class FileDirectory implements FileSystem{
    private String name;
    private List<FileSystem> list = new ArrayList<>();
    public FileDirectory(String name){
        this.name = name;
    }

    public void addComponent(FileSystem file){
        list.add(file);
    }
    public void display(){
        System.out.println("Directory name" + name);
        for(FileSystem file: list){
            file.display();
        }
    }
}

class Composite{
    public static void main(String args[]){
        FileDirectory directory = new FileDirectory("Directory");
        directory.addComponent(new File("A-file"));
        directory.addComponent(new File("B-file"));
        directory.display();
    }
}