package dao.impl;

import model.NewsLetter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsletterDAOTest {
    private NewsletterDAO newsletterDAO;

    @BeforeEach
    void setUp() {
        newsletterDAO = new NewsletterDAO();
    }

    @AfterEach
    void tearDown() {
        newsletterDAO = null; // Clean up
    }

    @Test
    void create() {
        NewsLetter newsletter = new NewsLetter("test@example.com", true);
        NewsLetter createdNewsletter = newsletterDAO.create(newsletter);
        assertNotNull(createdNewsletter);
        assertEquals("test@example.com", createdNewsletter.getEmail());
        assertTrue(createdNewsletter.isEnabled());
    }

    @Test
    void update() {
        // First create a newsletter
        NewsLetter newsletter = new NewsLetter("update@example.com", true);
        NewsLetter createdNewsletter = newsletterDAO.create(newsletter);

        // Update the newsletter
        createdNewsletter.setEmail("updated@example.com");
        createdNewsletter.setEnabled(false);
        NewsLetter updatedNewsletter = newsletterDAO.update(createdNewsletter);

        assertNotNull(updatedNewsletter);
        assertEquals("updated@example.com", updatedNewsletter.getEmail());
        assertFalse(updatedNewsletter.isEnabled());
    }

    @Test
    void listAll() {

        List<NewsLetter> newsletters = newsletterDAO.listAll();
        assertFalse(newsletters.isEmpty());
        assertEquals(7, newsletters.size());
    }
}
