
package droca;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "dataset", catalog = "droca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Dataset.findAll", query = "SELECT d FROM Dataset d"),
    @NamedQuery(name = "Dataset.findByDid", query = "SELECT d FROM Dataset d WHERE d.did = :did"),
    @NamedQuery(name = "Dataset.findByName", query = "SELECT d FROM Dataset d WHERE d.name = :name")})
public class Dataset implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Did")
    private Integer did;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    public Dataset() {
    }

    public Dataset(Integer did) {
        this.did = did;
    }

    public Dataset(Integer did, String name) {
        this.did = did;
        this.name = name;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        Integer oldDid = this.did;
        this.did = did;
        changeSupport.firePropertyChange("did", oldDid, did);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dataset)) {
            return false;
        }
        Dataset other = (Dataset) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "droca.Dataset[ did=" + did + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
