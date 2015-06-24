/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import sv.com.iavasoft.entities.Autos;
import sv.com.iavasoft.utils.Filtros;

/**
 *
 * @author ricardo
 */
@Stateless
public class AutosDao extends GenericDao<Autos> {

    public AutosDao() {
        super(Autos.class);
    }
    
    public Autos getWithIdDao(Long id) {
        return super.getWithId(id);
    }
    
    public List<Autos> findAutosByFiltros(Filtros filtros) {
        List<Autos> autosList = null;
        
        try {
            CriteriaBuilder cb = super.getCriteriaBuilder();
            CriteriaQuery<Autos> cq = cb.createQuery(Autos.class);
            Root<Autos> from = cq.from(Autos.class);
            
            ArrayList<Predicate> ands = new ArrayList<>();
            
            if (filtros.getMarca() != null) {
                Path<Long>  marcaPath = from.get("modelo").get("marca").get("id");
                ands.add(cb.equal(marcaPath, filtros.getMarca()));
            }
            
            if (filtros.getModelo() != null) {
                Path<Long> modeloPath = from.get("modelo").get("id");
                ands.add(cb.equal(modeloPath, filtros.getModelo()));
            }
            
            if (filtros.getAnio() != null && !filtros.getAnio().isEmpty()) {
                Path<String> anioPath = from.get("anio");
                ands.add(cb.equal(anioPath, filtros.getAnio()));
            }
            
            if (filtros.getTipo() != null) {
                Path<Long> tipoPath = from.get("tipo").get("id");
                ands.add(cb.equal(tipoPath, filtros.getTipo()));
            }
            
            if (filtros.getPropietario() != null) {
                Path<Long> propietarioPath = from.get("propietario").get("id");
                ands.add(cb.equal(propietarioPath, filtros.getPropietario()));
            }
            
            if (filtros.getPlaca() != null && !filtros.getPlaca().isEmpty()) {
                Path<String> placaPath = from.get("placas");
                ands.add(cb.like(placaPath, "%" + filtros.getPlaca() + "%"));
            }
            
            if (filtros.getNumMotor() != null && !filtros.getNumMotor().isEmpty()) {
                Path<String> numMotorPath = from.get("numMotor");
                ands.add(cb.like(numMotorPath, "%" + filtros.getNumMotor() + "%"));
            }
            
            if (filtros.getNumChasis() != null && !filtros.getNumChasis().isEmpty()) {
                Path<String> numChasisPath = from.get("numChasis");
                ands.add(cb.like(numChasisPath, "%" + filtros.getNumChasis() + "%"));
            }
            
            cq.where(ands.toArray(new Predicate[ands.size()]));
            
            autosList = super.executeQryList(cq);
            System.out.println("TERMINAAAAAAAA.... " + autosList);
        } catch (Exception e) {
            Logger.getLogger(AutosDao.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        
        
        return autosList;
    }

}
