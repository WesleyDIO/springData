package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import net.weg.api.model.dto.IDTO;

public class BotaoSalvar extends Button {

    BotaoSalvar(IService service, IDTO dto) throws Exception {
        service.cadastrar(dto);
    }
}
