package com.packagename.myapp;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class FragenService implements Serializable {

    List<Frage> initFragenKatalog() {
        List<Frage> alleFragen = new ArrayList<Frage>();

        alleFragen.add(new Frage("A1", "Ist ein GS Zeichen vorhanden?", "GS-Zeichen = geprüfte Sicherheit z.B. vom TÜV ausgestellt\n" + "Belegt Anforderungen an die Produktsicherheit\n" + "VORSICHT! Ein Medizinprodukt (A2) darf kein GS haben!", false));
        alleFragen.add(new Frage("A2", "Medizinischer Einsatz?", "", false));
        alleFragen.add(new Frage("A3", "Schützt vor Gefahren?", "", false));
        alleFragen.add(new Frage("A4", "Klasse/Kat II oder III?", "",false));
        alleFragen.add(new Frage("A5", "Hat eine Messfunktion?", "", false));
        alleFragen.add(new Frage("A6", "Ist es ein Spielzeug?", "", false));
        alleFragen.add(new Frage("A7", "für Kinder < 3 Jahre?", "", false));
        alleFragen.add(new Frage("A8", "Ist es eine Maschine?", "", false));
        alleFragen.add(new Frage("A9", "elektrisch?", "", false));
        alleFragen.add(new Frage("A10", "ist laut und wird im Freien verwendet?", "", false));
        alleFragen.add(new Frage("A11", "ist Batterie oder enthält Batterie?", "", false));
        alleFragen.add(new Frage("A12", "E-kennzeichnungs-relevant?", "", false));
        alleFragen.add(new Frage("A13", "mit Funk?", "", false));

        return alleFragen;
    }

    public boolean check(Collection<Frage> someFragen) {

        return false;
    }

    public List<Frage> filterItems(Collection<Frage> geaenderteFragen) {
        List<Frage> restlicheFragen = new ArrayList<Frage>();
        for (Frage frage: geaenderteFragen) {
            if(frage.getBezeichnung().equals("A1") && frage.getAntwort()) {
                restlicheFragen.add(frage);
                geaenderteFragen.remove(frage.getBezeichnung().equals("A3"));
            }

        }

        return restlicheFragen;
    }
}
