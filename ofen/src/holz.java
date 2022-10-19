public class holz implements verheizbar{
    private String art;
    private int brenndauer;
    private boolean hartHolz;

    public holz(String art, int brenndauer, boolean hartHolz) {
        this.art = art;
        this.brenndauer = brenndauer;
        this.hartHolz = hartHolz;
    }

    public void printStats() {
        System.out.println(art + " brennt für " + brenndauer + " minuten");
    }

    public int verbrennen() {
        return brenndauer;
    }
}
