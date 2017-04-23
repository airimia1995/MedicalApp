package com.appMedial.jsp.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MesajeRepository extends CrudRepository<Mesaje,Integer> {
	 @Query("select m from Mesaje m  where m.receiver_email=:recEmail and m.sender_email=:sendEmail")
	List<Mesaje> findAllByReceiver_idAndSender_id( @Param("recEmail") String recEmail, @Param("sendEmail") String sendEmail);
}
