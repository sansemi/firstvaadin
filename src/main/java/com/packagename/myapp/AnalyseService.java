package com.packagename.myapp;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalyseService implements Serializable  {

    public String check(List<Frage> fragen) {
        if (fragen == null || fragen.isEmpty()) {
            return "Sie müssen die Fragen beantworten";
        } else {
            List<Boolean> antworten = new ArrayList<Boolean>();
            antworten = fragen.stream().map(Frage::getAntwort).collect(Collectors.toList());
            return "Das Ergebnis der Analyse wird präsentiert!";
        }
    }
}
