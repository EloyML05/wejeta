

package net.ausiasmarch.wejeta.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.wejeta.entity.TipousuarioEntity;
import net.ausiasmarch.wejeta.service.TipousuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/Tipousuario")
public class TipousuarioController {

    @Autowired
    TipousuarioService oTipousuarioService;

    @GetMapping("/restricted")
    public ResponseEntity<String> restricted() {
        return ResponseEntity.ok("\"" + oTipousuarioService.RestrictedArea() + "\"");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipousuarioEntity> getTipousuarioById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(oTipousuarioService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<TipousuarioEntity> createTipousuario(@RequestBody TipousuarioEntity oTipousuarioEntity) {
        return new ResponseEntity<TipousuarioEntity>(oTipousuarioService.create(oTipousuarioEntity), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<TipousuarioEntity> updateTipousuario(@RequestBody TipousuarioEntity oTipousuarioEntity) {
        return  new ResponseEntity<TipousuarioEntity>(oTipousuarioService.update(oTipousuarioEntity), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Page<TipousuarioEntity>> getPage(Pageable oPageable) {
        return new ResponseEntity<Page<TipousuarioEntity>>(oTipousuarioService.getPage(oPageable), HttpStatus.OK);
    }
    @GetMapping("/getAllList")
    public ResponseEntity<List<TipousuarioEntity>> getAllList() {
        return new ResponseEntity<List<TipousuarioEntity>>(oTipousuarioService.getAllList(), HttpStatus.OK);
    }
}
