package com.sgaraba.library.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate; 
import static org.junit.jupiter.api.Assertions.assertSame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.sgaraba.library.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BorrowedBookTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BorrowedBook.class);
        BorrowedBook borrowedBook1 = new BorrowedBook();
        borrowedBook1.setId(1L);
        BorrowedBook borrowedBook2 = new BorrowedBook();
        borrowedBook2.setId(borrowedBook1.getId());
        assertThat(borrowedBook1).isEqualTo(borrowedBook2);
        borrowedBook2.setId(2L);
        assertThat(borrowedBook1).isNotEqualTo(borrowedBook2);
        borrowedBook1.setId(null);
        assertThat(borrowedBook1).isNotEqualTo(borrowedBook2);
    }

     //Crear una prestacion de un libro
    @Test
    public void testCreateBorrowedBook() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Fisica para ingenieros");
        book1.setPublishYear("2015");
        book1.setCopies(5);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Publicador");

        book1.setPublisher(publisher1);

        BorrowedBook newBorrowedBook = new BorrowedBook();
        newBorrowedBook.setBorrowDate(LocalDate.of(2023,8,17));
        
        LocalDate expectedDate = LocalDate.of(2023,8,17);

        assertNotNull(newBorrowedBook.getBorrowDate());
        assertEquals(expectedDate, newBorrowedBook.getBorrowDate());
        
    } 
    //Crear una prestacion de un libro con cliente
    @Test
    public void testBorrowedBookClient() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Fisica para ingenieros");
        book1.setPublishYear("2015");
        book1.setCopies(5);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Publicador");

        book1.setPublisher(publisher1);

        BorrowedBook newBorrowedBook = new BorrowedBook();
        newBorrowedBook.setBorrowDate(LocalDate.of(2023,8,17));
        
        Client newClient = new Client();
        newClient.setFirstName("Cliente 1");

        newBorrowedBook.setClient(newClient);

        assertNotNull(newBorrowedBook.getClient());  
        assertSame(newClient, newBorrowedBook.getClient());    
    } 
}
