package models;

public class Category {
    private int categoryId;
    private String title;
    private String description;
    private String subtitle;

    public Category(int categoryId, String title, String description, String subtitle) {
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.subtitle = subtitle;
    }

    public Category(String title, String description, String subtitle) {
        this.title = title;
        this.description = description;
        this.subtitle = subtitle;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
