package com.vs.repo;
import com.vs.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
	
	@Query("select u from Appointment  u where  u.booking_id=:n")
    public Appointment findByBooking_id(@Param("n") Long id);

}
