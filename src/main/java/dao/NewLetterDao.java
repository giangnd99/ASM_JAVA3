package dao;

import model.Newsletters;

public interface NewLetterDao {
    public void create (Newsletters Newsletters);
    public void update (Newsletters Newsletters);

    public void delete (String id);

}
