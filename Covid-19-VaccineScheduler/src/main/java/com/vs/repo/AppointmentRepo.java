package com.vs.repo;
import com.vs.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
	
	@Query("select i from Appointment  i where  i.bookingid=:n")
    public Appointment findByBooking_id(@Param("n") Long id);

}
