/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "CoursePlan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoursePlan.findAll", query = "SELECT c FROM CoursePlan c"),
    @NamedQuery(name = "CoursePlan.findByCoursePlanID", query = "SELECT c FROM CoursePlan c WHERE c.coursePlanID = :coursePlanID"),
    @NamedQuery(name = "CoursePlan.findByCoursePlanName", query = "SELECT c FROM CoursePlan c WHERE c.coursePlanName = :coursePlanName")})
public class CoursePlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coursePlan_ID")
    private Integer coursePlanID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "coursePlan_Name")
    private String coursePlanName;

    public CoursePlan() {
    }

    public CoursePlan(Integer coursePlanID) {
        this.coursePlanID = coursePlanID;
    }

    public CoursePlan(Integer coursePlanID, String coursePlanName) {
        this.coursePlanID = coursePlanID;
        this.coursePlanName = coursePlanName;
    }

    public Integer getCoursePlanID() {
        return coursePlanID;
    }

    public void setCoursePlanID(Integer coursePlanID) {
        this.coursePlanID = coursePlanID;
    }

    public String getCoursePlanName() {
        return coursePlanName;
    }

    public void setCoursePlanName(String coursePlanName) {
        this.coursePlanName = coursePlanName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursePlanID != null ? coursePlanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursePlan)) {
            return false;
        }
        CoursePlan other = (CoursePlan) object;
        if ((this.coursePlanID == null && other.coursePlanID != null) || (this.coursePlanID != null && !this.coursePlanID.equals(other.coursePlanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.CoursePlan[ coursePlanID=" + coursePlanID + " ]";
    }
    
}
