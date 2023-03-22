import java.util.Objects;

public class ProfileInfo {
    private String name;
    private String lastVisit;
    private String dateOfBirth;

    public String getName() {
        return name;
    }

    public ProfileInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public ProfileInfo setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public ProfileInfo setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileInfo that = (ProfileInfo) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(lastVisit, that.lastVisit)) return false;
        return Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastVisit != null ? lastVisit.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProfileInfo{" +
                "name='" + name + '\'' +
                ", lastVisit='" + lastVisit + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
