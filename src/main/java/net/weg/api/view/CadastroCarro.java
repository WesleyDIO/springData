package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;


public class CadastroCarro extends FormLayout {

    private final CarroService carroService;
    public CadastroCarro( CarroService carroService, Dialog dialog) {
        this.carroService = carroService;
        TextField placa = new TextField("placa");
        TextField marca = new TextField("marca");
        TextField cor = new TextField("cor");
        TextField modelo = new TextField("modelo");
        IntegerField ano = new IntegerField("ano");
        NumberField preco = new NumberField("preço");
        Button salvar = new Button("Salvar", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                CarroCadastroDTO carroCadastroDTO = new CarroCadastroDTO(placa.getValue(),marca.getValue(),cor.getValue(),modelo.getValue()
                ,preco.getValue(),ano.getValue());
                try {
                    carroService.cadastrar(carroCadastroDTO);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                dialog.close();
            }
        });
        Button cancelar = new Button("Cancelar", e -> dialog.close());
        dialog.getFooter().add(cancelar, salvar);
        add(placa, marca, cor, modelo, ano, preco);
    }
}
