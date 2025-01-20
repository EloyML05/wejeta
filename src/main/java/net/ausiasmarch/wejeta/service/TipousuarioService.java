package net.ausiasmarch.wejeta.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import net.ausiasmarch.wejeta.entity.TipousuarioEntity;
import net.ausiasmarch.wejeta.repository.TipousuarioRepository;

@Service
@AllArgsConstructor
public class TipousuarioService {

    HttpServletRequest oHttpServletRequest;

    TipousuarioRepository oTipousuarioRepository;

    AuthService oAuthService;

    public String RestrictedArea() {
        if (oHttpServletRequest.getAttribute("email") == null) {
            return "No tienes permisos para acceder a esta zona";
        } else {
            return "Bienvenido a la zona restringida";
        }
    }
    
    public TipousuarioEntity get(Long id){
            return oTipousuarioRepository.findById(id).get();
            
    }

    public Page<TipousuarioEntity> getPage(Pageable oPageable) {
        return oTipousuarioRepository.findAll(oPageable);
    }
    public TipousuarioEntity getById(Long id) {
            return oTipousuarioRepository.findById(id).get();
       
    }
    public void delete(Long id) {
            oTipousuarioRepository.deleteById(id);
        
    }

    public TipousuarioEntity update(TipousuarioEntity oTipousuarioEntity) {
           return oTipousuarioRepository.save(oTipousuarioEntity);
        
    }

    public TipousuarioEntity create(TipousuarioEntity oTipousuarioEntity) {
       return oTipousuarioRepository.save(oTipousuarioEntity);
    }
    public List<TipousuarioEntity> getAllList() {return oTipousuarioRepository.findAll();} 
}
