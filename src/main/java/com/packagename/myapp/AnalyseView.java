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

        /*Grid<Frage> grid = new Grid<>(Frage.class);

        Button button = new Button("Greet");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui ->
                        ui.navigate("greeting")));
        add(button);
        */

    }

    public String privet() {
        String otvet = "Hallo du!";
        new Span();
        return otvet;
    }

}
