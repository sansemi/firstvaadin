package com.packagename.myapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("calc")
public class AnalyseView extends VerticalLayout {

    public AnalyseView() {
        add();
        add();

        Button button = new Button("Greet");
        Button button2 = new Button("Greeta");
        button.addClickListener(e ->
                button.getUI().ifPresent(ui ->
                        ui.navigate("greeting")));
        add(button);
        //Hier mein hotfix
    }

    public String privet() {
        String  antwort = "Hallo lieber du!";
        String  antwort2 = "Hallo liebe sie!";
        String  antwort3 = "Hallo lieben wir!";
        String  antwort4 = "Hallo Realese!";
        String  antwort5= "Hallo Develop!";
        String  antwort6= "Hallo Develop2!";
        String  antwort7 = "Hallo Bugfix!";
        String  antwort8= "Hallo Develop!";
        String  antwort9 = "Hallo Bugfix!";
        String  antwort10 = "Hallo Realese!";
        String  antwort11 = "Hallo Russich!";
        String  antwort12 = "Hallo Russich1!";
        String  antwort13 = "Hallo Russich2!";
        String  antwort14 = "Hallo Russich3!";
        String  antwort15 = "Hallo Russich3!";
        String  antwort16 = "Hallo Russich3!";
        String  antwort17 = "Hallo Russich3!";
        String  antwort18 = "Hallo Russich3!";

        new Span();
        return antwort;
    }

}
