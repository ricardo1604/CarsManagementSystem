/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao;

import java.util.List;
import javax.ejb.Local;
import sv.com.iavasoft.entities.Autos;

/**
 *
 * @author ricardo
 */
@Local
public interface AutosFacade {
    public abstract void save(Autos auto);

    public abstract Autos update(Autos auto);
    
    public abstract void delete(Autos auto);

    public abstract Autos find(int entityID);

    public abstract List<Autos> findAll();
}
