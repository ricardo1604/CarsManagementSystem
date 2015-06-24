/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.facade;

import java.util.List;
import javax.ejb.Local;
import sv.com.iavasoft.entities.Autos;
import sv.com.iavasoft.utils.Filtros;

/**
 *
 * @author ricardo
 */
@Local
public interface AutosFacade {
    public abstract void save(Autos auto);

    public abstract Autos update(Autos auto);
    
    public abstract void delete(Autos auto);

    public abstract Autos find(Long entityID);

    public abstract List<Autos> findAll();
    
    public List<Autos> findAutosByFiltros(Filtros filtros);
    
    public Autos getWithIdDao(Long id);
}
