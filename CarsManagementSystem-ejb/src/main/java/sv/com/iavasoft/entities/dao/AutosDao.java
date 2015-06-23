/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
    
    public List<Autos> findAutosByFiltros(Filtros filtros) {
        List<Autos> autosList = null;
        
        try {
            CriteriaBuilder cb = super.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Autos.class);
            Root<Autos> from = cq.from(Autos.class);
            
            //La lista de los whers
            
            
            
        } catch (Exception e) {
        }
        
        
        return autosList;
    }

}
