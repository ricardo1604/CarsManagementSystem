/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao;

import javax.ejb.Stateless;
import sv.com.iavasoft.entities.Modelos;

/**
 *
 * @author ricardo
 */
@Stateless
public class ModelosDao extends GenericDao<Modelos>{

    public ModelosDao() {
        super(Modelos.class);
    }
    
}
