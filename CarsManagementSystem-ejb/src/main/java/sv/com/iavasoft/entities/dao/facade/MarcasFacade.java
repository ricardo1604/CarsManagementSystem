/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.facade;

import java.util.List;
import sv.com.iavasoft.entities.Marcas;

/**
 *
 * @author ricardo
 */
public interface MarcasFacade {
    public abstract void save(Marcas marca);

    public abstract Marcas update(Marcas marca);
    
    public abstract void delete(Marcas marca);

    public abstract Marcas find(int entityID);

    public abstract List<Marcas> findAll();
}
