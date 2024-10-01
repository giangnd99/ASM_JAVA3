package dao;


import model.News;

import java.util.List;

public interface NewsDao {
   public void create(News news);
   public    void update(News news);
   public void delete(String id);
   public News findByNewsId(String id);
   List<News> getNewsList();
    public List<News> findByCategory(String categoryId);
    public List<News> findByAuthor(String author);
}
