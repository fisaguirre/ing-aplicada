package com.sgaraba.library.domain;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;


import java.util.HashSet;
import java.util.Set;
import com.sgaraba.library.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AuthorTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Author.class);
        Author author1 = new Author();
        author1.setId(1L);
        Author author2 = new Author();
        author2.setId(author1.getId());
        assertThat(author1).isEqualTo(author2);
        author2.setId(2L);
        assertThat(author1).isNotEqualTo(author2);
        author1.setId(null);
        assertThat(author1).isNotEqualTo(author2);
    }

    //Comprobar que se cree el author
    @Test
    public void testCreateAuthor() {
        Author newAuthor = new Author();
        newAuthor.setFirstName("Fernando");
        newAuthor.setLastName("Isaguirre");
        assertNotNull(newAuthor.getFirstName());
        assertEquals("Fernando", newAuthor.getFirstName());
    } 

    //Comprobar que 2 objetos sean diferentes
    @Test
    public void testCreateTwoAuthor() {
        Author newAuthor = new Author();
        newAuthor.setFirstName("Fernando");
        newAuthor.setLastName("Isaguirre");
        Author newAuthor2 = new Author();
        newAuthor2.setFirstName("Agustin");
        newAuthor2.setLastName("Nunez");
        assertNotSame(newAuthor,newAuthor2);
    } 

    //Comprobar que se agrega un libro a un autor
    @Test
    public void testAddBookToAuthor() {
        Author newAuthor = new Author();
        newAuthor.setFirstName("Fernando");
        newAuthor.setLastName("Isaguirre");

        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("Fisica para ingenieros");
        book1.setPublishYear("2015");
        book1.setCopies(5);

        newAuthor.addBook(book1);
        assertNotNull(newAuthor.getBooks());
    }
    
    //verificar que se agregaron varios libros a un autor
    @Test
    public void testAddBooksToAuthor() {
        Author newAuthor = new Author();
        newAuthor.setFirstName("Fernando");
        newAuthor.setLastName("Isaguirre");

        Book book1 = new Book();
        book1.setName("Fisica para ingenieros");
        book1.setPublishYear("2015");
        book1.setCopies(5);

        Book book2 = new Book();
        book2.setName("Python for dummies");
        book2.setPublishYear("2012");
        book2.setCopies(10);

        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);

        newAuthor.setBooks(books);

        assertNotNull(newAuthor.getBooks());
        assertEquals(books, newAuthor.getBooks());
    }

   
}
