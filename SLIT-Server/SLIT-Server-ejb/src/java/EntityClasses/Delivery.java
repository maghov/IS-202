/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "Delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByDeliveryID", query = "SELECT d FROM Delivery d WHERE d.deliveryID = :deliveryID"),
    @NamedQuery(name = "Delivery.findByDeliveryName", query = "SELECT d FROM Delivery d WHERE d.deliveryName = :deliveryName"),
    @NamedQuery(name = "Delivery.findByDeliveryComment", query = "SELECT d FROM Delivery d WHERE d.deliveryComment = :deliveryComment"),
    @NamedQuery(name = "Delivery.findByDeliveryStatus", query = "SELECT d FROM Delivery d WHERE d.deliveryStatus = :deliveryStatus"),
    @NamedQuery(name = "Delivery.findByDeliveryDate", query = "SELECT d FROM Delivery d WHERE d.deliveryDate = :deliveryDate")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "delivery_ID")
    private Integer deliveryID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "delivery_Name")
    private String deliveryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "delivery_Comment")
    private String deliveryComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery_Status")
    private boolean deliveryStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery_Date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @OneToMany(mappedBy = "fKdeliveryID")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "FK_approvalQueue_ID", referencedColumnName = "approvalQueue_ID")
    @ManyToOne
    private ApprovalQueue fKapprovalQueueID;
    @JoinColumn(name = "student_user_ID", referencedColumnName = "student_user_ID")
    @ManyToOne
    private Student studentuserID;
    @JoinColumn(name = "teacher_user_ID", referencedColumnName = "teacher_user_ID")
    @ManyToOne
    private Teacher teacheruserID;
    @JoinColumn(name = "tutor_user_ID", referencedColumnName = "tutor_user_ID")
    @ManyToOne
    private Tutor tutoruserID;

    public Delivery() {
    }

    public Delivery(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Delivery(Integer deliveryID, String deliveryName, String deliveryComment, boolean deliveryStatus, Date deliveryDate) {
        this.deliveryID = deliveryID;
        this.deliveryName = deliveryName;
        this.deliveryComment = deliveryComment;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
    }

    public Integer getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryComment() {
        return deliveryComment;
    }

    public void setDeliveryComment(String deliveryComment) {
        this.deliveryComment = deliveryComment;
    }

    public boolean getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public Student getStudentuserID() {
        return studentuserID;
    }

    public void setStudentuserID(Student studentuserID) {
        this.studentuserID = studentuserID;
    }

    public Teacher getTeacheruserID() {
        return teacheruserID;
    }

    public void setTeacheruserID(Teacher teacheruserID) {
        this.teacheruserID = teacheruserID;
    }

    public Tutor getTutoruserID() {
        return tutoruserID;
    }

    public void setTutoruserID(Tutor tutoruserID) {
        this.tutoruserID = tutoruserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryID != null ? deliveryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryID == null && other.deliveryID != null) || (this.deliveryID != null && !this.deliveryID.equals(other.deliveryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Delivery[ deliveryID=" + deliveryID + " ]";
    }
    
}
