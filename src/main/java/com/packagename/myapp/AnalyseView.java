package com.packagename.myapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("calc")
public class AnalyseView extends VerticalLayout {

    public AnalyseView() {
        add();

        Button button = new Button("Greet");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui ->
                        ui.navigate("greeting")));
        add(button);
        //Hier mein hotfix
    }

    public String privet() {
        String  antwort = "Hallo lieber du!";
        String  antwort2 = "Hallo liebe sie!";

        new Span();
        return antwort;
    }

}
