package live.daniel.entity;

import javax.persistence.*;

@Entity
@Table(name = "Registry")
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "link")
    private String link;

    @Column(name = "ip")
    private String ip;

    @Column(name = "date")
    private String date;

    public Registry() {
    }

    public Registry(String link, String ip, String date) {
        this.link = link;
        this.ip = ip;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public String getIp() {
        return ip;
    }

    public String getDate() {
        return date;
    }

    public Registry(long id, String link, String ip, String date) {
        this.id = id;
        this.link = link;
        this.ip = ip;
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ",\"link\":\"" + link + "\",\"ip\":\"" + ip + "\",\"date\":\"" + date + "\"}";
    }
}
