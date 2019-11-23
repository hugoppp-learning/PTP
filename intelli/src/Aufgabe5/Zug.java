package Aufgabe5;

public class Zug {
    /**
     * Referenz auf den ersten Wagen des Zuges
     * Wenn 'ersterWagen = null' ist kein Wagen angehängt
     */
    private Wagen ersterWagen = null;

    /**
     * Hängt einen Wagen an den letzen Wagen des Zuges an, falls es keinen Wageb gibt, an den Zug.
     *
     * @param neuerWagen wird ans Ende angehängt
     */
    public void anhaengen(Wagen neuerWagen) {
        //Falls noch kein Wagen da ist, wird einer an den Zug gehängt
        if (ersterWagen == null) {
            ersterWagen = neuerWagen;
        } else {
            //sonst wird an den letzten Wagen der neue rangehängt
            Wagen letzerWagen = findeVorgängerVon(null);
            letzerWagen.naechsterWagen = neuerWagen;
        }
    }

    /**
     * Hängt einen bestimmten Wagen ab, der Wagen davor (bzw. Zug) und Wagen danach werden verbunden:
     * Zug-Wagen1-Eingabe-Wagen3  -->> Zug-Wagen1-Wagen3
     *
     * @param wagen wird abgehägt
     */
    public void abhaengen(Wagen wagen) {
        //1. Fall: ersten Wagen abhängen
        if (ersterWagen == wagen) {
            Wagen wagenZuEntfernen = ersterWagen;
            ersterWagen = wagenZuEntfernen.naechsterWagen;
            wagenZuEntfernen.naechsterWagen = null;
            
        } else {
            //2. Fall: irgendein anderen Wagen abhängen;
            //z.B Zug-gesuchterWagen-wagenZuEntfernen-wagen3
            Wagen gesuchterWagen = findeVorgängerVon(wagen);
            Wagen wagenZuEnfernen = gesuchterWagen.naechsterWagen;
            gesuchterWagen.naechsterWagen = wagenZuEnfernen.naechsterWagen;
        }

    }
    
    /**
     * @param wagen nächsterWagen des gesuchten Wagens
     * @return der Wagen, der vor dem eingegebenen Wagen hägt, zB: Zug-Wagen1-Ausgabe-Eingabe-Wagen4
     */
    private Wagen findeVorgängerVon(Wagen wagen) {
        Wagen aktuellerWagen = ersterWagen;
        while (aktuellerWagen.naechsterWagen != wagen) {
            aktuellerWagen = aktuellerWagen.naechsterWagen;
        }
        return aktuellerWagen;
    }
}