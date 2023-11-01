package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.CarroService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import net.weg.api.service.UsuarioService;

public class CadastroSeguro extends FormLayout {

    private SeguroService seguroService;

    CadastroSeguro(SeguradoraService seguradoraService, CarroService carroService, UsuarioService usuarioService
    ,SeguroService seguroService,Dialog dialog){
        this.seguroService = seguroService;
        NumberField valor = new NumberField("Valor");
        TextField descricao = new TextField("Descrição");
        NumberField valorFranquia = new NumberField("Valor da Franquia");
        Select<Seguradora> seguradoraSelect = new Select<>();
        seguradoraSelect.setLabel("Seguradora");
        seguradoraSelect.setItems(seguradoraService.buscarTodos());
        Select<Carro> veiculoSelect = new Select<>();
        veiculoSelect.setLabel("Veículo");
        veiculoSelect.setItems(carroService.buscarTodos());
        Select<Cliente> usuarioSelect = new Select<>();
        usuarioSelect.setLabel("Usuário");
        usuarioSelect.setItems(usuarioService.buscarTodos());
        Button salvar = new Button("Salvar", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(valor.getValue(),descricao.getValue(),valorFranquia.getValue(),seguradoraSelect.getValue()
                        ,veiculoSelect.getValue(),usuarioSelect.getValue());
                try {
                    seguroService.salvar(seguroCadastroDTO);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                dialog.close();
            }
        });
        Button cancelar = new Button("Cancelar", e -> dialog.close());
        dialog.getFooter().add(cancelar, salvar);
        add(valor,descricao,valorFranquia,veiculoSelect,seguradoraSelect,usuarioSelect);
    }
}
