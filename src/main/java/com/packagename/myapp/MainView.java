package com.packagename.myapp;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.StringToBooleanConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.renderers.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.grid.cellrenderers.client.editoraware.renderers.CheckboxRenderer;

import java.util.*;

@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    private final Grid<Frage> fragenTabelle = new Grid<>(Frage.class);
    private List<Frage> meineFragen = new ArrayList<>();

    private final String columnName_Bezeichnung = "Bezeichnung";
    private final String columnName_Frage = "Frage";
//    private final String columnName_Antwort = "Antwort";

    public MainView(@Autowired AnalyseService analyseService, @Autowired FragenService fragenService) {

        Icon drawer = VaadinIcon.MENU.create();
        Span title = new Span("Legilator");
        Icon help = VaadinIcon.QUESTION_CIRCLE.create();
        help.addClickListener(
                e -> {
                    Notification.show("Bitte beantworten Sie die Fragen von oben nach unten!");
                });
        HorizontalLayout header = new HorizontalLayout(drawer, title, help);
        header.expand(title);
        header.setPadding(true);
        header.setWidth("100%");

        HorizontalLayout myHorizontalLayout = new HorizontalLayout();
        Button buttonAnalyse = new Button("Analysieren", new Icon(VaadinIcon.ABACUS),
                e -> analyseService.check(meineFragen));

        buttonAnalyse.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        buttonAnalyse.addClickShortcut(Key.ENTER);

        Button buttonAbbrechen = new Button("Abbrechen", new Icon(VaadinIcon.ARROW_BACKWARD));
        buttonAbbrechen.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonAbbrechen.addClickShortcut(Key.ABORT);
        myHorizontalLayout.setJustifyContentMode(JustifyContentMode.END);
        myHorizontalLayout.add(buttonAnalyse, buttonAbbrechen);

//        RouteConfiguration configuration = RouteConfiguration.forApplicationScope();
//        configuration.setRoute("main", MainView.class);
//        configuration.setRoute("calc", MyForm.class);

        meineFragen = fragenService.initFragenKatalog();
        fragenTabelle.setItems(meineFragen);

        Checkbox antorten = new Checkbox();
        antorten.setValue(false);
        antorten.onEnabledStateChanged(true);

//        ListDataProvider<Frage> listDataProvider = (ListDataProvider<Frage>) fragenTabelle.getDataProvider();
//        Collection<Frage> items = listDataProvider.getItems();

        Grid.Column colFragenBezeichnung = fragenTabelle.getColumnByKey(Frage.getNameBezeichnung());
        Grid.Column colFragenText = fragenTabelle.getColumnByKey(Frage.getNameLangText()).setAutoWidth(true);
        Grid.Column colFragenJaNeinAntwort = fragenTabelle.getColumnByKey(Frage.getNameAntwort()).setAutoWidth(true);
        Grid.Column colKommentarZurFrage = fragenTabelle.getColumnByKey(Frage.getNameKommentar()).setAutoWidth(true);
        Grid.Column colIsRelevant = fragenTabelle.getColumnByKey(Frage.getNameIsRelevant());

        colFragenText.setHeader(columnName_Frage).setAutoWidth(true);
        fragenTabelle.removeColumn(colFragenBezeichnung);
        fragenTabelle.removeColumn(colIsRelevant);
        fragenTabelle.setColumnOrder(colFragenText, colKommentarZurFrage, colFragenJaNeinAntwort);

        Binder<Frage> binder = new Binder<>(Frage.class);
        Editor<Frage> editor = fragenTabelle.getEditor();
        editor.setBinder(binder);
        editor.setBuffered(true);

        Div validationStatus = new Div();
        validationStatus.setId("validation");

        TextField antwortFeld = new TextField();
        binder.forField(antwortFeld)
                .withConverter(
                        new StringToBooleanConverter("Antwort muss Ja oder Nein sein!", "Ja", "Nein"))
                .withStatusLabel(validationStatus).bind("antwort");
        colFragenJaNeinAntwort.setEditorComponent(antwortFeld);

        Collection<Button> editButtons = Collections
                .newSetFromMap(new WeakHashMap<>());

        Grid.Column<Frage> editorColumn = fragenTabelle.addComponentColumn(frage -> {
            Button edit = new Button("Zum Antworten bitte clicken!");
            edit.addThemeName(Lumo.LIGHT);
            edit.addClassName("edit");
            edit.addClickListener(e -> {
                editor.editItem(frage);
                antwortFeld.setRequired(true);
            });
            edit.setEnabled(!editor.isOpen());
            editButtons.add(edit);
            return edit;
        });

        editor.addOpenListener(e -> editButtons.stream().forEach(button -> button.setEnabled(!editor.isOpen())));
        editor.addCloseListener(e -> editButtons.stream().forEach(button -> button.setEnabled(!editor.isOpen())));

        ListDataProvider<Frage> listDataProvider = (ListDataProvider<Frage>) fragenTabelle.getDataProvider();
        Collection<Frage> items = listDataProvider.getItems();

        Button save = new Button("Speichern", e -> {
            editor.save();
//            fragenService.check(items);
            fragenTabelle.setItems(fragenService.filterItems(items));
        });

        save.addClassName("save");
        Button cancel = new Button("Abbrechen", e -> editor.cancel());
        cancel.addClassName("cancel");

        fragenTabelle.getElement().addEventListener("keyup", event -> editor.cancel()).setFilter("event.key === 'Escape' || event.key === 'Esc'");

        Div buttons = new Div(save, cancel);
        editorColumn.setEditorComponent(buttons);

//        editor.addSaveListener(event -> event.getItem().getAntwort());

        setSizeFull();
        setAlignItems(Alignment.END);
        fragenTabelle.addThemeName(Lumo.DARK);

        add(header, validationStatus, fragenTabelle,  myHorizontalLayout);
    }

}
