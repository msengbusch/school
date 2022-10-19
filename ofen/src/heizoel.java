public class heizoel extends oel implements verheizbar {

    public heizoel () {
        super("heizoel", 4, false);
    }

    public int verbrennen () {
        return brenndauer;
    }
}
