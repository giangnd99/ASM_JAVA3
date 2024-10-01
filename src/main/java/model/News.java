package model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class News {
  private String id;
  private String title;
  private String content;
  private String image;
  private java.sql.Date postedDate;
  private String author;
  private long viewCount;
  private String categoryId;
  private long home;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public java.sql.Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(java.sql.Date postedDate) {
    this.postedDate = postedDate;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public long getViewCount() {
    return viewCount;
  }

  public void setViewCount(long viewCount) {
    this.viewCount = viewCount;
  }


  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }


  public long getHome() {
    return home;
  }

  public void setHome(long home) {
    this.home = home;
  }

}
