package com.packagename.myapp;

import com.vaadin.flow.component.select.Select;

import java.util.ArrayList;
import java.util.List;

public class Frage {

    public String vorname;
    public String title;
    private String data;
    public String bezeichnung;
    public String langText;
    public boolean antwort;
    public boolean isRelevant = false;
    public String kommentar;
    private String name;

    public boolean isRelevant() {
        return isRelevant;
    }

    public void setRelevant(boolean relevant) {
        isRelevant = relevant;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public static String getNameBezeichnung() {
        return "bezeichnung";
    }

    public static String getNameLangText() {
        return "langText";
    }

    public static String getNameAntwort() {
        return "antwort";
    }

    public static String getNameKommentar() {
        return "kommentar";
    }

    public static String getNameIsRelevant() {
        return "relevant";
    }

    public boolean getAntwort() {
        return antwort;
    }

    public void setAntwort(boolean antwort) {
        this.antwort = antwort;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getLangText() {
        return langText;
    }

    public void setLangText(String langText) {
        this.langText = langText;
    }

    Frage(String bezeichnung, String langText, String kommentar, boolean antwort){
        this.bezeichnung = bezeichnung;
        this.langText = langText;
        this.kommentar = kommentar;
        this.antwort = antwort;
    }
}

//TODO: master