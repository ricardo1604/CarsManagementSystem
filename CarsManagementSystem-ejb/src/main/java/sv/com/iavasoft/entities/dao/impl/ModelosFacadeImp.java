/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.iavasoft.entities.Modelos;
import sv.com.iavasoft.entities.dao.ModelosDao;
import sv.com.iavasoft.entities.dao.facade.ModelosFacade;

/**
 *
 * @author ricardo
 */
@Stateless
public class ModelosFacadeImp implements ModelosFacade {

    @EJB
    private ModelosDao modelosDao;
    
    @Override
    public void save(Modelos modelo) {
        modelosDao.save(modelo);
    }

    @Override
    public Modelos update(Modelos modelo) {
        return modelosDao.update(modelo);
    }

    @Override
    public void delete(Modelos modelo) {
        modelosDao.delete(modelo);
    }

    @Override
    public Modelos find(int entityID) {
        return modelosDao.find(entityID);
    }

    @Override
    public List<Modelos> findAll() {
        return modelosDao.findAll();
    }

}
