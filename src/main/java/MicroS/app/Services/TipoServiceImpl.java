package MicroS.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Tipo;
import MicroS.app.Persistence.Repositories.TipoRepository;

@Service
public class TipoServiceImpl implements TipoService {

    private TipoRepository tipoRepository;
    private TareaService tareaService;

    public TipoServiceImpl(TipoRepository tipoRepository, TareaService tareaService) {
        this.tipoRepository = tipoRepository;
        this.tareaService = tareaService;
    }

    @Override
    public List<Tipo> getTipos() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo addTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    @Override
    public Tipo deleteTipo(Integer id) {
        tareaService.deleteTareabyTipoid(id);

        Tipo t = tipoRepository.findById(id).orElse(null);

        if (t != null) {
            tipoRepository.delete(t);
        }

        return t;
    }

}
