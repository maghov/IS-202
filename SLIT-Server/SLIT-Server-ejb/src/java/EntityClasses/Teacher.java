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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "Teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacheruserID", query = "SELECT t FROM Teacher t WHERE t.teacheruserID = :teacheruserID"),
    @NamedQuery(name = "Teacher.findByTeacherOffice", query = "SELECT t FROM Teacher t WHERE t.teacherOffice = :teacherOffice")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacher_user_ID")
    private Integer teacheruserID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "teacher_Office")
    private String teacherOffice;
    @OneToMany(mappedBy = "teacheruserID")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "FK_approvalQueue_ID", referencedColumnName = "approvalQueue_ID")
    @ManyToOne
    private ApprovalQueue fKapprovalQueueID;
    @JoinColumn(name = "teacher_user_ID", referencedColumnName = "user_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(mappedBy = "teacheruserID")
    private Collection<Delivery> deliveryCollection;
    @OneToMany(mappedBy = "teacheruserID")
    private Collection<Module> moduleCollection;

    public Teacher() {
    }

    public Teacher(Integer teacheruserID) {
        this.teacheruserID = teacheruserID;
    }

    public Teacher(Integer teacheruserID, String teacherOffice) {
        this.teacheruserID = teacheruserID;
        this.teacherOffice = teacherOffice;
    }

    public Integer getTeacheruserID() {
        return teacheruserID;
    }

    public void setTeacheruserID(Integer teacheruserID) {
        this.teacheruserID = teacheruserID;
    }

    public String getTeacherOffice() {
        return teacherOffice;
    }

    public void setTeacherOffice(String teacherOffice) {
        this.teacherOffice = teacherOffice;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
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
    public Collection<Delivery> getDeliveryCollection() {
        return deliveryCollection;
    }

    public void setDeliveryCollection(Collection<Delivery> deliveryCollection) {
        this.deliveryCollection = deliveryCollection;
    }

    @XmlTransient
    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacheruserID != null ? teacheruserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacheruserID == null && other.teacheruserID != null) || (this.teacheruserID != null && !this.teacheruserID.equals(other.teacheruserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Teacher[ teacheruserID=" + teacheruserID + " ]";
    }
    
}
