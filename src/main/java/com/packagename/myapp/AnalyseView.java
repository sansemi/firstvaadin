package com.packagename.myapp;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("calc")
public class AnalyseView extends VerticalLayout {

    public AnalyseView() {
        add();
    }

    public String privet() {
        String  antwort = "Hallo du!";
        new Span();
        return antwort;
    }

}
