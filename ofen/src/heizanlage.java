import java.util.LinkedList;
import java.util.Queue;

public class heizanlage {
    private Queue<verheizbar> brennmaterial = new LinkedList<>();


    public void add(verheizbar material) {
        System.out.println("added");
        brennmaterial.add(material);
    }

    public void info() {
        System.out.println(brennmaterial);
    }

}
