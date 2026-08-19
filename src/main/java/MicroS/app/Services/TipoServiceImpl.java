package MicroS.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Tipo;
import MicroS.app.Persistence.Repositories.TipoRepository;

@Service
public class TipoServiceImpl implements TipoService {

    private final TipoRepository tipoRepository;

    public TipoServiceImpl(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Override
    public List<Tipo> getTipos() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo addTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

}
