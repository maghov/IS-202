/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "Tutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByTutoruserID", query = "SELECT t FROM Tutor t WHERE t.tutoruserID = :tutoruserID")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tutor_user_ID")
    private Integer tutoruserID;
    @JoinColumn(name = "FK_approvalQueue_ID", referencedColumnName = "approvalQueue_ID")
    @ManyToOne
    private ApprovalQueue fKapprovalQueueID;
    @JoinColumn(name = "tutor_user_ID", referencedColumnName = "user_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(mappedBy = "tutoruserID")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(mappedBy = "tutoruserID")
    private Collection<Delivery> deliveryCollection;

    public Tutor() {
    }

    public Tutor(Integer tutoruserID) {
        this.tutoruserID = tutoruserID;
    }

    public Integer getTutoruserID() {
        return tutoruserID;
    }

    public void setTutoruserID(Integer tutoruserID) {
        this.tutoruserID = tutoruserID;
    }

    public ApprovalQueue getFKapprovalQueueID() {
        return fKapprovalQueueID;
    }

    public void setFKapprovalQueueID(ApprovalQueue fKapprovalQueueID) {
        this.fKapprovalQueueID = fKapprovalQueueID;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<Delivery> getDeliveryCollection() {
        return deliveryCollection;
    }

    public void setDeliveryCollection(Collection<Delivery> deliveryCollection) {
        this.deliveryCollection = deliveryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tutoruserID != null ? tutoruserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.tutoruserID == null && other.tutoruserID != null) || (this.tutoruserID != null && !this.tutoruserID.equals(other.tutoruserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Tutor[ tutoruserID=" + tutoruserID + " ]";
    }
    
}
