package com.packagename.myapp;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.klaudeta.PaginatedGrid;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

	DataProvider dataProvider;
    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {

        // Use TextField for standard text input
        TextField textField = new TextField("Твоё имя");
        textField.addThemeName("bordered");

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Скажи привет!",
                e -> Notification.show(service.greet(textField.getValue())));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

        add(textField, button);
        
//        PaginatedGrid<Address> grid = new PaginatedGrid<>();
//
//    	grid.addColumn(Address::getId).setHeader("ID");
//    	grid.addColumn(Address::getCountry).setHeader("Country").setSortable(true);
//    	grid.addColumn(Address::getState).setHeader("State").setSortable(true);
//    	grid.addColumn(Address::getName).setHeader("Name").setSortable(true);
//    	grid.addColumn(Address::getAddress).setHeader("Address").setSortable(true);
//    	grid.setItems(dataProvider.getItems());
    	
    	// Sets the max number of items to be rendered on the grid for each page
//    	grid.setPageSize(16);
    	
    	// Sets how many pages should be visible on the pagination before and/or after the current selected page
//    	grid.setPaginatorSize(5);
    }

}
