public class Main {
    public static void main(String[] args) {
        holz holz1 = new holz("Eiche", 30, true);
        buchenholz buchenholz1 = new buchenholz();
        heizoel heizoel1 = new heizoel();
        sonnenblumenoel sonnenblumenoel1 = new sonnenblumenoel();

        holz1.printStats();

        heizanlage heizung = new heizanlage();

        System.out.println("success");

        heizung.add(holz1);
        heizung.add(buchenholz1);
        heizung.add(heizoel1);
        heizung.info();
    }
}
