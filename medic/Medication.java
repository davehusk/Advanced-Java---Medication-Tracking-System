import java.util.Date;

public class Medication {
    private int id;
    private String name;
    private Date expirationDate;

    public Medication(int id, String name, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired() {
        return expirationDate.before(new Date());
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Expiration Date: " + expirationDate;
    }
}
