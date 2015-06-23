/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.iavasoft.entities.Propietario;
import sv.com.iavasoft.entities.dao.PropietarioDao;
import sv.com.iavasoft.entities.dao.facade.PropietarioFacade;

/**
 *
 * @author ricardo
 */
@Stateless
public class PropietarioFacadeImp implements PropietarioFacade {

    @EJB
    private PropietarioDao propietarioDao;
    
    @Override
    public void save(Propietario propietario) {
        propietarioDao.save(propietario);
    }

    @Override
    public Propietario update(Propietario propietario) {
        return propietarioDao.update(propietario);
    }

    @Override
    public void delete(Propietario propietario) {
        propietarioDao.delete(propietario);
    }

    @Override
    public Propietario find(Long entityID) {
        return propietarioDao.find(entityID);
    }

    @Override
    public List<Propietario> findAll() {
        return propietarioDao.findAll();
    }
    
}
