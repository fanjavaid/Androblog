package fanjavaid.com.androblog.model;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by fanjavaid on 12/9/16.
 */

public class Category {
    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private Date createdAt;

    @Expose
    private Date updatedAt;


    // Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
