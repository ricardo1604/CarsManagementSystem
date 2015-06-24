/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sv.com.iavasoft.entities.Autos;
import sv.com.iavasoft.entities.dao.AutosDao;
import sv.com.iavasoft.entities.dao.facade.AutosFacade;
import sv.com.iavasoft.utils.Filtros;

/**
 *
 * @author ricardo
 */
@Stateless
public class AutosFacadeImp implements AutosFacade {

    @EJB
    private AutosDao autosDao;
    
    @Override
    public void save(Autos auto) {
        autosDao.save(auto);
    }

    @Override
    public Autos update(Autos auto) {
        return autosDao.update(auto);
    }

    @Override
    public void delete(Autos auto) {
        autosDao.delete(auto);
    }

    @Override
    public Autos find(Long entityID) {
        return autosDao.find(entityID);
    }

    @Override
    public List<Autos> findAll() {
        return autosDao.findAll();
    }

    @Override
    public List<Autos> findAutosByFiltros(Filtros filtros) {
        return autosDao.findAutosByFiltros(filtros);
    }

    @Override
    public Autos getWithIdDao(Long id) {
        return autosDao.getWithIdDao(id);
    }

}
