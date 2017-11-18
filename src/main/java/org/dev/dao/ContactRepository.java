package org.dev.dao;

import org.dev.entites.Contacts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contacts,Long> {
	
	@Query("select c from Contacts c where c.nom like:mc")
	public Page<Contacts> chercherContact (@Param ("mc")String mc ,Pageable pageable);

}
