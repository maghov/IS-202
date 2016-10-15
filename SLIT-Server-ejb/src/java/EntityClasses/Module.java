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
@Table(name = "Module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModulId", query = "SELECT m FROM Module m WHERE m.modulId = :modulId"),
    @NamedQuery(name = "Module.findByTittel", query = "SELECT m FROM Module m WHERE m.tittel = :tittel")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "modulId")
    private Integer modulId;
    @Size(max = 50)
    @Column(name = "tittel")
    private String tittel;

    public Module() {
    }

    public Module(Integer modulId) {
        this.modulId = modulId;
    }

    public Integer getModulId() {
        return modulId;
    }

    public void setModulId(Integer modulId) {
        this.modulId = modulId;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulId != null ? modulId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.modulId == null && other.modulId != null) || (this.modulId != null && !this.modulId.equals(other.modulId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Module[ modulId=" + modulId + " ]";
    }
    
}
