/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.iavasoft.entities.Marcas;
import sv.com.iavasoft.entities.dao.MarcasDao;
import sv.com.iavasoft.entities.dao.facade.MarcasFacade;

/**
 *
 * @author ricardo
 */
@Stateless
public class MarcasFacadeImp implements MarcasFacade {

    @EJB
    private MarcasDao marcasDao;
    
    @Override
    public void save(Marcas marca) {
        marcasDao.save(marca);
    }

    @Override
    public Marcas update(Marcas marca) {
        return marcasDao.update(marca);
    }

    @Override
    public void delete(Marcas marca) {
        marcasDao.delete(marca);
    }

    @Override
    public Marcas find(Long entityID) {
        return marcasDao.find(entityID);
    }

    @Override
    public List<Marcas> findAll() {
        return marcasDao.findAll();
    }
    
}
