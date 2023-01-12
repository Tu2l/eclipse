package com.cg.app;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.entity.Author;
import com.cg.entity.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Book book1 = new Book();
		book1.setIsbn("asd123");
		book1.setTitle("Java");
		book1.setPrice(300);

		Author author1 = new Author();
		author1.setId("auth1");
		author1.setName("James Goshling");

		List<Book> bookList1 = new ArrayList<>();
		bookList1.add(book1);

		author1.setBooks(bookList1);

		List<Author> authorList1 = new ArrayList<>();
		authorList1.add(author1);

		book1.setAuthors(authorList1);
		////
		Book book2 = new Book();
		book2.setIsbn("ABC");
		book2.setTitle("C");
		book2.setPrice(100);

		Author author2 = new Author();
		author2.setId("auth2");
		author2.setName("Denish");

		List<Book> bookList2 = new ArrayList<>();
		bookList2.add(book2);

		author2.setBooks(bookList2);

		List<Author> authorList2 = new ArrayList<>();
		authorList2.add(author2);

		book2.setAuthors(authorList2);

		em.persist(book1);
		em.persist(book2);

		em.getTransaction().commit();

		// a.Query all books in database.
		System.out.println("-----------------------------------------");
		System.out.println("a.Query all books in database");
		System.out.println("-----------------------------------------");
		getAllBooks(em).forEach(System.out::println);
		System.out.println("-----------------------------------------");

		// b.Query all books written by given author name
		System.out.println("b.Query all books written by given author name");
		System.out.println("-----------------------------------------");
		findBooksByAuthor("James Goshling", em).forEach(System.out::println);
		System.out.println("-----------------------------------------");

		// c.List all books with given price range. e.g. between Rs. 500 to 1000
		System.out.println("c.List all books with given price range. e.g. between Rs. 500 to 1000");
		System.out.println("-----------------------------------------");
		getAllBooksByPriceRange(100, 200, em).forEach(System.out::println);
		System.out.println("-----------------------------------------");

		// d.List the author name for given book id.
		System.out.println("d.List the author name for given book id.");
		System.out.println("-----------------------------------------");
		getAuthorByISBN("ABC", em).forEach(System.out::println);
		System.out.println("-----------------------------------------");

		em.close();
		emf.close();

	}

	static List<String> getAuthorByISBN(String isbn, EntityManager em) {
		TypedQuery<String> query = em
				.createQuery("Select a.name from Book b inner join b.authors a where b.isbn =:isbn", String.class);
		query.setParameter("isbn", isbn);
		return query.getResultList();
	}

	static List<Book> getAllBooksByPriceRange(double start, double end, EntityManager em) {
		TypedQuery<Book> query = em.createQuery("Select b from Book b where b.price between :start and :end",
				Book.class);
		query.setParameter("start", start);
		query.setParameter("end", end);
		return query.getResultList();
	}

	static List<Book> getAllBooks(EntityManager em) {
		TypedQuery<Book> query = em.createQuery("Select b from Book b", Book.class);
		return query.getResultList();
	}

	static List<Book> findBooksByAuthor(String author, EntityManager em) {
		TypedQuery<Book> query = em.createQuery("Select b from Book b inner join b.authors a "
				+ "where a.id =(select a1.id from Author a1 where a1.name = :author)", Book.class);
		query.setParameter("author", author);
		return query.getResultList();
	}

}
