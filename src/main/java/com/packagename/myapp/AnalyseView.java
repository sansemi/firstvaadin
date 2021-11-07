package com.packagename.myapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

@Route("calc")
public class AnalyseView extends VerticalLayout {

    public AnalyseView() {

        add();

//        grid.addColumn(Frage::getKurzBezeichnung).setCaption("Bezeichnung");
//        grid.addColumn(Frage::getLangBezeichnung).setCaption("Frage");

        /*Grid<Frage> grid = new Grid<>(Frage.class);
        grid.setItems(fragenListe);

        Button button = new Button("Greet");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui ->
                        ui.navigate("greeting"))
        );
        add(button);
        Kommentar 1 vom master
        Fix 1 vom master
        add(button);
        schöner Text
        mehr text vom develop
        noch mehr text vom develop
        mehr text vom master
        noch mehr text vom master
        mehr 2 text vom develop
        */

    }

    public String privet() {
        String otvet = "Hallo тебе!";
        new Span();
        return otvet;
    }

}
