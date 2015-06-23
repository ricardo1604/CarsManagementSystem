/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.entities.dao;

import javax.ejb.Stateless;
import sv.com.iavasoft.entities.Autos;

/**
 *
 * @author ricardo
 */
@Stateless
public class AutosDao extends GenericDao<Autos> {

    public AutosDao() {
        super(Autos.class);
    }

}
