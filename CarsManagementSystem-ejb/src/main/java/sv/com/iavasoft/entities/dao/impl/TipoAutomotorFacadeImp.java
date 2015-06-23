/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.iavasoft.entities.TipoAutomotor;
import sv.com.iavasoft.entities.dao.TipoAutomotorDao;
import sv.com.iavasoft.entities.dao.facade.TipoAutomotorFacade;

/**
 *
 * @author ricardo
 */
@Stateless
public class TipoAutomotorFacadeImp implements TipoAutomotorFacade{

    @EJB
    private TipoAutomotorDao tipoAutomotorDao;
    
    @Override
    public void save(TipoAutomotor tipoAutomotor) {
        tipoAutomotorDao.save(tipoAutomotor);
    }

    @Override
    public TipoAutomotor update(TipoAutomotor tipoAutomotor) {
        return tipoAutomotorDao.update(tipoAutomotor);
    }

    @Override
    public void delete(TipoAutomotor tipoAutomotor) {
        tipoAutomotorDao.delete(tipoAutomotor);
    }

    @Override
    public TipoAutomotor find(Long entityID) {
        return tipoAutomotorDao.find(entityID);
    }

    @Override
    public List<TipoAutomotor> findAll() {
        return tipoAutomotorDao.findAll();
    }
    
}
