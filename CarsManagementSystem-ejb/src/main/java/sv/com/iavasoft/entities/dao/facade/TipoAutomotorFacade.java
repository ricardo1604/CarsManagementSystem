/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.facade;

import java.util.List;
import sv.com.iavasoft.entities.TipoAutomotor;

/**
 *
 * @author ricardo
 */
public interface TipoAutomotorFacade {
    public abstract void save(TipoAutomotor tipoAutomotor);

    public abstract TipoAutomotor update(TipoAutomotor tipoAutomotor);
    
    public abstract void delete(TipoAutomotor tipoAutomotor);

    public abstract TipoAutomotor find(int entityID);

    public abstract List<TipoAutomotor> findAll();
}
