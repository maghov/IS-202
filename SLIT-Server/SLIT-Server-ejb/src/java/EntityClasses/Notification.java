/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "Notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByNotificationID", query = "SELECT n FROM Notification n WHERE n.notificationID = :notificationID"),
    @NamedQuery(name = "Notification.findByNotificationTitle", query = "SELECT n FROM Notification n WHERE n.notificationTitle = :notificationTitle"),
    @NamedQuery(name = "Notification.findByNotificationText", query = "SELECT n FROM Notification n WHERE n.notificationText = :notificationText"),
    @NamedQuery(name = "Notification.findByNotificationDate", query = "SELECT n FROM Notification n WHERE n.notificationDate = :notificationDate")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notification_ID")
    private Integer notificationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "notification_Title")
    private String notificationTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "notification_Text")
    private String notificationText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notification_Date")
    @Temporal(TemporalType.DATE)
    private Date notificationDate;
    @JoinColumn(name = "FK_feedback_ID", referencedColumnName = "feedback_ID")
    @ManyToOne
    private Feedback fKfeedbackID;

    public Notification() {
    }

    public Notification(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public Notification(Integer notificationID, String notificationTitle, String notificationText, Date notificationDate) {
        this.notificationID = notificationID;
        this.notificationTitle = notificationTitle;
        this.notificationText = notificationText;
        this.notificationDate = notificationDate;
    }

    public Integer getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public Feedback getFKfeedbackID() {
        return fKfeedbackID;
    }

    public void setFKfeedbackID(Feedback fKfeedbackID) {
        this.fKfeedbackID = fKfeedbackID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationID != null ? notificationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationID == null && other.notificationID != null) || (this.notificationID != null && !this.notificationID.equals(other.notificationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Notification[ notificationID=" + notificationID + " ]";
    }
    
}
