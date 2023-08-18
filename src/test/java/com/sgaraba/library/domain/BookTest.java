package com.sgaraba.library.domain;


import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sgaraba.library.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Book.class);
        Book book1 = new Book();
        book1.setId(1L);
        Book book2 = new Book();
        book2.setId(book1.getId());
        assertThat(book1).isEqualTo(book2);
        book2.setId(2L);
        assertThat(book1).isNotEqualTo(book2);
        book1.setId(null);
        assertThat(book1).isNotEqualTo(book2);
    }
    

     //Comprobar que se cree el libro
    @Test
    public void testCreateBook() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Fisica para ingenieros");
        book1.setPublishYear("2015");
        book1.setCopies(5);

        assertNotNull(book1.getPublishYear());
        assertEquals("2015", book1.getPublishYear());
    } 

    
    //Comprobar qque se agregue un publisher
    @Test
    public void testAddPublisherToBook() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Fisica para ingenieros");
        book1.setPublishYear("2015");
        book1.setCopies(5);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Publicador");

        book1.setPublisher(publisher1);
        assertNotNull(book1.getPublisher());
        assertEquals("Publicador", book1.getPublisher().getName());
        
    } 

}
