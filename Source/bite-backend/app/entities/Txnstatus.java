package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
public class Txnstatus {
    private int statusId;
    private String status;

    @Id
    @Column(name = "statusId", nullable = false, insertable = true, updatable = true)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true, length = 150)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Txnstatus txnstatus = (Txnstatus) o;

        if (statusId != txnstatus.statusId) return false;
        if (status != null ? !status.equals(txnstatus.status) : txnstatus.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
