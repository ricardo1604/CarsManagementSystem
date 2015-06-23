/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.facade;

import java.util.List;
import sv.com.iavasoft.entities.Propietario;

/**
 *
 * @author ricardo
 */
public interface PropietarioFacade {
    public abstract void save(Propietario propietario);

    public abstract Propietario update(Propietario propietario);
    
    public abstract void delete(Propietario propietario);

    public abstract Propietario find(Long entityID);

    public abstract List<Propietario> findAll();
}
