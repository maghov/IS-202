/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.server;

import DataModel.DeliveryDataModel;
import javax.ejb.Remote;

/**
 *
 * @author magnushovik
 */
@Remote
public interface DeliverySessionBeanRemote {

    DeliveryDataModel getDeliveryById(int deliveryID);
    Boolean besvarelse(String deliveryName, String deliveryComment);
    
}
