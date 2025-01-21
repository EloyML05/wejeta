package net.ausiasmarch.wejeta.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.wejeta.entity.UsuarioEntity;
import net.ausiasmarch.wejeta.service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService oUsuarioService;

    @GetMapping("/restricted")
    public ResponseEntity<String> restricted() {
        return ResponseEntity.ok("\"" + oUsuarioService.RestrictedArea() + "\"");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(oUsuarioService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<UsuarioEntity> createUsuario(@RequestBody UsuarioEntity oUsuarioEntity) {
        return new ResponseEntity<UsuarioEntity>(oUsuarioService.create(oUsuarioEntity), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity oUsuarioEntity) {
        return  new ResponseEntity<UsuarioEntity>(oUsuarioService.update(oUsuarioEntity), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Page<UsuarioEntity>> getPage(Pageable oPageable) {
        return new ResponseEntity<Page<UsuarioEntity>>(oUsuarioService.getPage(oPageable), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable(value = "id") Long id) {
        oUsuarioService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
