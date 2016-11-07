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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "ApprovalQueue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApprovalQueue.findAll", query = "SELECT a FROM ApprovalQueue a"),
    @NamedQuery(name = "ApprovalQueue.findByApprovalQueueID", query = "SELECT a FROM ApprovalQueue a WHERE a.approvalQueueID = :approvalQueueID")})
public class ApprovalQueue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "approvalQueue_ID")
    private Integer approvalQueueID;
    @OneToMany(mappedBy = "fKapprovalQueueID")
    private Collection<Tutor> tutorCollection;
    @OneToMany(mappedBy = "fKapprovalQueueID")
    private Collection<Teacher> teacherCollection;
    @OneToMany(mappedBy = "fKapprovalQueueID")
    private Collection<Delivery> deliveryCollection;

    public ApprovalQueue() {
    }

    public ApprovalQueue(Integer approvalQueueID) {
        this.approvalQueueID = approvalQueueID;
    }

    public Integer getApprovalQueueID() {
        return approvalQueueID;
    }

    public void setApprovalQueueID(Integer approvalQueueID) {
        this.approvalQueueID = approvalQueueID;
    }

    @XmlTransient
    public Collection<Tutor> getTutorCollection() {
        return tutorCollection;
    }

    public void setTutorCollection(Collection<Tutor> tutorCollection) {
        this.tutorCollection = tutorCollection;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
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
        hash += (approvalQueueID != null ? approvalQueueID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApprovalQueue)) {
            return false;
        }
        ApprovalQueue other = (ApprovalQueue) object;
        if ((this.approvalQueueID == null && other.approvalQueueID != null) || (this.approvalQueueID != null && !this.approvalQueueID.equals(other.approvalQueueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.ApprovalQueue[ approvalQueueID=" + approvalQueueID + " ]";
    }
    
}
