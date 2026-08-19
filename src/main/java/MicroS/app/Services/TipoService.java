package MicroS.app.Services;

import java.util.List;


import MicroS.app.Persistence.Entities.Tipo;

public interface TipoService {

    public List<Tipo> getTipos();
    public Tipo addTipo(Tipo tipo);

}
