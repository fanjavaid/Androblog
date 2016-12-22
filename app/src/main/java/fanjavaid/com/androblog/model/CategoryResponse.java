package fanjavaid.com.androblog.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fanjavaid on 12/9/16.
 */

public class CategoryResponse {
    @Expose
    private Integer total;

    @Expose
    @SerializedName("data")
    private List<Category> categories;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "total=" + total +
                ", categories=" + categories +
                '}';
    }
}
