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


//        grid.addColumn(Frage::getKurzBezeichnung).setCaption("Bezeichnung");
//        grid.addColumn(Frage::getLangBezeichnung).setCaption("Frage");
        add();

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
        */

    }

    public String privet() {
        String otvet = "Привет тебе!";
        new Span();
        return otvet;
    }

}
