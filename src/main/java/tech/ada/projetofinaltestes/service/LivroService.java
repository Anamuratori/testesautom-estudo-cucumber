package tech.ada.projetofinaltestes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.projetofinaltestes.model.dto.LivroDTO;
import tech.ada.projetofinaltestes.model.entity.LivroEntity;
import tech.ada.projetofinaltestes.model.mapper.LivroMapper;
import tech.ada.projetofinaltestes.repository.LivroRepository;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository repository;
    @Autowired
    LivroMapper mapper;

    public LivroDTO criar (LivroDTO livroDTO) {
        LivroEntity livro = mapper.update(livroDTO);
        livro = repository.save(livro);
        return mapper.update(livro);
    }

    public List<LivroDTO> listar () {

        List<LivroEntity> livros = repository.findAll();
        return mapper.updateListDTO(livros);
    }

}
