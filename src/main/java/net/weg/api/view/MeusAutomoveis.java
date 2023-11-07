package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;



@Route(value = "/meus-autos", layout = NavBarApp.class)
public class MeusAutomoveis extends PaginaPadrao<Carro> {

    public MeusAutomoveis(CarroService carroService) {
        super("Meus Automóveis",carroService.buscarTodos(),Carro.class,);

        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("Meus Automoveis"));
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService, cadastro));

        hl.add(new Button("Novo Carro", e -> cadastro.open()));
        add(hl);
        Grid<Carro> veiculos = new Grid<>(Carro.class);
        veiculos.setItems(carroService.buscarTodos());
        add(veiculos);

    }
}
