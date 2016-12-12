/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userID = :userID"),
    @NamedQuery(name = "Users.findByUserUserName", query = "SELECT u FROM Users u WHERE u.userUserName = :userUserName"),
    @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Users.findByUserFirstName", query = "SELECT u FROM Users u WHERE u.userFirstName = :userFirstName"),
    @NamedQuery(name = "Users.findByUserLastName", query = "SELECT u FROM Users u WHERE u.userLastName = :userLastName"),
    @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.login", query = "SELECT u FROM Users u WHERE u.userUserName = :userUserName AND u.userPassword = :userPassword"),
    @NamedQuery(name = "Users.findByUserPhone", query = "SELECT u FROM Users u WHERE u.userPhone = :userPhone"),
    @NamedQuery(name=  "Users.findByUserNameOrMail", query = "SELECT u FROM Users u WHERE u.userUserName = :userUserName OR u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.findByUserTutor", query = "SELECT u FROM Users u WHERE u.userTutor = :userTutor")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_ID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "user_UserName")
    private String userUserName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "user_Password")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "user_FirstName")
    private String userFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "user_LastName")
    private String userLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "user_Email")
    private String userEmail;
    @Column(name = "user_Phone")
    private String userPhone;
    @Column(name = "user_Tutor")
    private Boolean userTutor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Tutor tutor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Teacher teacher;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Student student;

    public Users() {
    }

    public Users(Integer userID) {
        this.userID = userID;
    }

    public Users(Integer userID, String userUserName, String userPassword, String userFirstName, String userLastName, String userEmail) {
        this.userID = userID;
        this.userUserName = userUserName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Boolean getUserTutor() {
        return userTutor;
    }

    public void setUserTutor(Boolean userTutor) {
        this.userTutor = userTutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Users[ userID=" + userID + " ]";
    }


    public void setUserTutor(boolean userTutor) {
        this.userTutor = userTutor;
    }
    
}
