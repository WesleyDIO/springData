package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

public class CadastroUsuario extends FormLayout {

    private TextField usuario;
    private PasswordField senha;
    private IntegerField idade;
    private Grid<EnderecoCadastroDTO> gridEnderecos;
    private Dialog cadastroEndereco;
    private UsuarioService usuarioService;

    private Button novoEndereco;
    private Button salvar;
    private Button cancelar;

    CadastroUsuario(){
        cadastroEndereco.add(new CadastroEndereco(gridEnderecos,cadastroEndereco));
        novoEndereco = new Button("Novo Endereco", e -> cadastroEndereco.open());
        salvar = new Button("Salvar", e ->{
            Set<Endereco> enderecos = new HashSet<>();
            usuarioService.salvar(new UsuarioCadastroDTO(usuario.getValue(),senha.getValue(),idade.getValue(),));
        });
        add(usuario,senha,idade,novoEndereco,gridEnderecos,cadastroEndereco);

    }
}
