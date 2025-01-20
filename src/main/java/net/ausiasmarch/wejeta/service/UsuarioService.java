package net.ausiasmarch.wejeta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import net.ausiasmarch.wejeta.entity.UsuarioEntity;
import net.ausiasmarch.wejeta.exception.UnauthorizedAccessException;
import net.ausiasmarch.wejeta.repository.TipousuarioRepository;
import net.ausiasmarch.wejeta.repository.UsuarioRepository;

@Service
@AllArgsConstructor
public class UsuarioService {

    HttpServletRequest oHttpServletRequest;

    UsuarioRepository oUsuarioRepository;

    AuthService oAuthService;

    TipousuarioRepository oTipousuarioRepository;

    public String RestrictedArea() {
        if (oHttpServletRequest.getAttribute("email") == null) {
            return "No tienes permisos para acceder a esta zona";
        } else {
            return "Bienvenido a la zona restringida";
        }
    }
    
    public UsuarioEntity get(Long id){
            return oUsuarioRepository.findById(id).get();
            
    }

    public Page<UsuarioEntity> getPage(Pageable oPageable) {
        return oUsuarioRepository.findAll(oPageable);
    }
    public UsuarioEntity getById(Long id) {
            return oUsuarioRepository.findById(id).get();
       
    }
    public void delete(Long id) {
            oUsuarioRepository.deleteById(id);
        
    }

    public UsuarioEntity update(UsuarioEntity oUsuarioEntity) {
           return oUsuarioRepository.save(oUsuarioEntity);
        
    }

    public UsuarioEntity create(UsuarioEntity oUsuarioEntity) {
       oUsuarioEntity.setTipousuario(oTipousuarioRepository.findById(oUsuarioEntity.getTipousuario().getId()).get());
       return oUsuarioRepository.save(oUsuarioEntity);
    }
}
