/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.facade;

import java.util.List;
import sv.com.iavasoft.entities.Modelos;

/**
 *
 * @author ricardo
 */
public interface ModelosFacade {
    public abstract void save(Modelos modelo);

    public abstract Modelos update(Modelos modelo);
    
    public abstract void delete(Modelos modelo);

    public abstract Modelos find(Long entityID);

    public abstract List<Modelos> findAll();
    
    public List<Modelos> findByMarca(Long marcaId);
    
}
