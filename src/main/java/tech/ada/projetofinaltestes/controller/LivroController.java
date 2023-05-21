package tech.ada.projetofinaltestes.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.projetofinaltestes.model.dto.LivroDTO;
import tech.ada.projetofinaltestes.model.dto.MensagemDTO;
import tech.ada.projetofinaltestes.service.LivroService;

@Slf4j
@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid LivroDTO livroDTO){

        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(livroService.criar(livroDTO));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(e.getMessage()));
        }
    }

    @GetMapping()
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(livroService.listar());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensagemDTO(e.getMessage()));
        }
    }
}
