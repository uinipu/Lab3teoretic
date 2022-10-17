public class Note {
    int wert;

    public Note(int wert) {
        this.wert = wert;
    }

    public boolean wirdAufgerundet() {
        if (this.wert < 38)
            return false;
        return true;
    }

    public boolean istAusreichend() {
        if (this.aufrunden() >= 40)
            return true;
        return false;
    }

    public int nachsterVielfaceVon5(int x) {
        int y = x;
        while (y % 5 != 0)
            y++;
        return y;
    }

    public int aufrunden() {
        if (nachsterVielfaceVon5(this.wert) - this.wert < 3)
            return nachsterVielfaceVon5(this.wert);
        return this.wert;
    }
}