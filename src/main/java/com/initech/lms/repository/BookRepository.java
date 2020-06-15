package com.initech.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.initech.lms.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByIsbn(long isbn);
	
	@Query(value="SELECT count(inclusion_date) FROM lms.book WHERE inclusion_date >= DATE(CURDATE()) - INTERVAL 7 DAY AND archive_flag = false", nativeQuery=true)
	public int countByInclusionDate();
	
	public List<Book> findAllByBookCategory(String bookCategory);
	
	@Query(value="select * from lms.book where archive_flag = false order by book_category", nativeQuery=true)
	public List<Book> findAllBooksByArchiveFlag();
	
}
