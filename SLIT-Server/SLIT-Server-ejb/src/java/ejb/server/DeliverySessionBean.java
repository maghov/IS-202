/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import Common.DataModelConverter;
import DataModel.DeliveryDataModel;
import EntityClasses.Delivery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DeliverySessionBean implements DeliverySessionBeanRemote {

    @PersistenceContext(unitName = "SLIT-Server-ejbPU")
    private EntityManager em;
    
    

    @Override
    public boolean besvarelse(String deliveryName, String deliveryComment)
    {   
        try {
        Delivery delivery = new Delivery();
        delivery.setDeliveryComment(deliveryComment);
        delivery.setDeliveryName(deliveryName);
        em.persist(delivery);
            
          return true; 
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        

        return true; 
    }
    
}