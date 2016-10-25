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
@Table(name = "Feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByFeedbackID", query = "SELECT f FROM Feedback f WHERE f.feedbackID = :feedbackID"),
    @NamedQuery(name = "Feedback.findByFeedbackComment", query = "SELECT f FROM Feedback f WHERE f.feedbackComment = :feedbackComment"),
    @NamedQuery(name = "Feedback.findByFeedbackHiddenComment", query = "SELECT f FROM Feedback f WHERE f.feedbackHiddenComment = :feedbackHiddenComment"),
    @NamedQuery(name = "Feedback.findByFeedbackDate", query = "SELECT f FROM Feedback f WHERE f.feedbackDate = :feedbackDate"),
    @NamedQuery(name = "Feedback.findByFeedbackApproved", query = "SELECT f FROM Feedback f WHERE f.feedbackApproved = :feedbackApproved")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "feedback_ID")
    private Integer feedbackID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "feedback_Comment")
    private String feedbackComment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "feedback_HiddenComment")
    private String feedbackHiddenComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feedback_Date")
    @Temporal(TemporalType.DATE)
    private Date feedbackDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "feedback_Approved")
    private boolean feedbackApproved;
    @JoinColumn(name = "FK_delivery_ID", referencedColumnName = "delivery_ID")
    @ManyToOne
    private Delivery fKdeliveryID;
    @JoinColumn(name = "student_user_ID", referencedColumnName = "student_user_ID")
    @ManyToOne
    private Student studentuserID;
    @JoinColumn(name = "teacher_user_ID", referencedColumnName = "teacher_user_ID")
    @ManyToOne
    private Teacher teacheruserID;
    @JoinColumn(name = "tutor_user_ID", referencedColumnName = "tutor_user_ID")
    @ManyToOne
    private Tutor tutoruserID;
    @OneToMany(mappedBy = "fKfeedbackID")
    private Collection<Notification> notificationCollection;

    public Feedback() {
    }

    public Feedback(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Feedback(Integer feedbackID, String feedbackComment, String feedbackHiddenComment, Date feedbackDate, boolean feedbackApproved) {
        this.feedbackID = feedbackID;
        this.feedbackComment = feedbackComment;
        this.feedbackHiddenComment = feedbackHiddenComment;
        this.feedbackDate = feedbackDate;
        this.feedbackApproved = feedbackApproved;
    }

    public Integer getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFeedbackComment() {
        return feedbackComment;
    }

    public void setFeedbackComment(String feedbackComment) {
        this.feedbackComment = feedbackComment;
    }

    public String getFeedbackHiddenComment() {
        return feedbackHiddenComment;
    }

    public void setFeedbackHiddenComment(String feedbackHiddenComment) {
        this.feedbackHiddenComment = feedbackHiddenComment;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public boolean getFeedbackApproved() {
        return feedbackApproved;
    }

    public void setFeedbackApproved(boolean feedbackApproved) {
        this.feedbackApproved = feedbackApproved;
    }

    public Delivery getFKdeliveryID() {
        return fKdeliveryID;
    }

    public void setFKdeliveryID(Delivery fKdeliveryID) {
        this.fKdeliveryID = fKdeliveryID;
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

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackID != null ? feedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.feedbackID == null && other.feedbackID != null) || (this.feedbackID != null && !this.feedbackID.equals(other.feedbackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Feedback[ feedbackID=" + feedbackID + " ]";
    }
    
}
