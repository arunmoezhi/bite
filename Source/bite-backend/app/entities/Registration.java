package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Daniel on 6/27/2015.
 */
@Entity
public class Registration {
    private int id;
    private String email;
    private Timestamp registeredOn;
    private byte sendNotifications;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 500)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "registeredOn", nullable = false, insertable = true, updatable = true)
    public Timestamp getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Timestamp registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Basic
    @Column(name = "sendNotifications", nullable = false, insertable = true, updatable = true)
    public byte getSendNotifications() {
        return sendNotifications;
    }

    public void setSendNotifications(byte sendNotifications) {
        this.sendNotifications = sendNotifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        if (id != that.id) return false;
        if (sendNotifications != that.sendNotifications) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (registeredOn != null ? !registeredOn.equals(that.registeredOn) : that.registeredOn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (registeredOn != null ? registeredOn.hashCode() : 0);
        result = 31 * result + (int) sendNotifications;
        return result;
    }
}
