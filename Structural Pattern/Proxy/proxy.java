// Subject interface
interface Image {
    void display();
}

// RealSubject class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
class ProxyPatternExample {
    public static void main(String[] args) {
        // Using RealImage directly
        Image realImage = new RealImage("example.jpg");
        realImage.display();

        System.out.println("----------");

        // Using ProxyImage to control access to RealImage
        Image proxyImage = new ProxyImage("example.jpg");
        proxyImage.display();
    }
}

// ProxyImage is the proxy that controls access to RealImage.