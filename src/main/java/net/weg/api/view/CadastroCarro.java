package net.weg.api.view;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/cadastro-carro")
public class CadastroCarro extends FormLayout {

    public CadastroCarro(){
        TextField placa = new TextField("placa");
        TextField marca = new TextField("marca");
        TextField cor = new TextField("cor");
        TextField modelo = new TextField("modelo");
        NumberField ano = new NumberField("ano");
        NumberField preco = new NumberField("preço");

        add(placa,marca,cor,modelo,ano,preco);
    }
}
