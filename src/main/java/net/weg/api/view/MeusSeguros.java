package net.weg.api.view;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguro;

@Route( value = "/meus-seguros", layout = NavBarApp.class)
public class MeusSeguros extends VerticalLayout{

    public MeusSeguros(){
     this.add(new H1("Meus Seguros"));
      this.add(new Grid<>(Seguro.class));
    }
}
