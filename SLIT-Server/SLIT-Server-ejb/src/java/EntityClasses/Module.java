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
@Table(name = "Module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleID", query = "SELECT m FROM Module m WHERE m.moduleID = :moduleID"),
    @NamedQuery(name = "Module.findByModuleName", query = "SELECT m FROM Module m WHERE m.moduleName = :moduleName"),
    @NamedQuery(name = "Module.findByModuleTask", query = "SELECT m FROM Module m WHERE m.moduleTask = :moduleTask"),
    @NamedQuery(name = "Module.findByModuleResources", query = "SELECT m FROM Module m WHERE m.moduleResources = :moduleResources"),
    @NamedQuery(name = "Module.findByModuleAim", query = "SELECT m FROM Module m WHERE m.moduleAim = :moduleAim"),
    @NamedQuery(name = "Module.findByModuleDeadline", query = "SELECT m FROM Module m WHERE m.moduleDeadline = :moduleDeadline"),
    @NamedQuery(name = "Module.findByModuleObligatory", query = "SELECT m FROM Module m WHERE m.moduleObligatory = :moduleObligatory")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "module_ID")
    private Integer moduleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "module_Name")
    private String moduleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "module_Task")
    private String moduleTask;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "module_Resources")
    private String moduleResources;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "module_Aim")
    private String moduleAim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "module_Deadline")
    @Temporal(TemporalType.DATE)
    private Date moduleDeadline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "module_Obligatory")
    private boolean moduleObligatory;
    @JoinColumn(name = "teacher_user_ID", referencedColumnName = "teacher_user_ID")
    @ManyToOne
    private Teacher teacheruserID;

    public Module() {
    }

    public Module(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public Module(Integer moduleID, String moduleName, String moduleTask, String moduleResources, String moduleAim, Date moduleDeadline, boolean moduleObligatory) {
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.moduleTask = moduleTask;
        this.moduleResources = moduleResources;
        this.moduleAim = moduleAim;
        this.moduleDeadline = moduleDeadline;
        this.moduleObligatory = moduleObligatory;
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleTask() {
        return moduleTask;
    }

    public void setModuleTask(String moduleTask) {
        this.moduleTask = moduleTask;
    }

    public String getModuleResources() {
        return moduleResources;
    }

    public void setModuleResources(String moduleResources) {
        this.moduleResources = moduleResources;
    }

    public String getModuleAim() {
        return moduleAim;
    }

    public void setModuleAim(String moduleAim) {
        this.moduleAim = moduleAim;
    }

    public Date getModuleDeadline() {
        return moduleDeadline;
    }

    public void setModuleDeadline(Date moduleDeadline) {
        this.moduleDeadline = moduleDeadline;
    }

    public boolean getModuleObligatory() {
        return moduleObligatory;
    }

    public void setModuleObligatory(boolean moduleObligatory) {
        this.moduleObligatory = moduleObligatory;
    }

    public Teacher getTeacheruserID() {
        return teacheruserID;
    }

    public void setTeacheruserID(Teacher teacheruserID) {
        this.teacheruserID = teacheruserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleID != null ? moduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleID == null && other.moduleID != null) || (this.moduleID != null && !this.moduleID.equals(other.moduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Module[ moduleID=" + moduleID + " ]";
    }
    
}
