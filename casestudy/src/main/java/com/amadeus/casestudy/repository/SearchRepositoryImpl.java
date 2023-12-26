package com.amadeus.casestudy.repository;

import com.amadeus.casestudy.model.Flight;
import com.amadeus.casestudy.model.RoundTripDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchRepositoryImpl implements SearchRepository {

    private final EntityManager em;

    @Autowired
    public SearchRepositoryImpl(JpaContext context) {
        this.em = context.getEntityManagerByManagedType(Flight.class);;
    }

    @Override
    public Iterable<Flight> searchFlights(String departureAirport, String arrivalAirport, Date departureTime) {
        // First three parameters are all ANDed together conditionally
        // If return time is present, then ADD the following results as well:
        //   departure -- arrival airports swapped and flight.departureTime = returnTime
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Flight> cq = cb.createQuery(Flight.class);
        Root<Flight> root = cq.from(Flight.class);

        List<Predicate> predicates = new ArrayList<>();
        if (departureAirport != null) {
            predicates.add(cb.equal(root.get("departure"), departureAirport));
        }
        if (arrivalAirport != null) {
            predicates.add(cb.equal(root.get("arrival"), arrivalAirport));
        }
        if (departureTime != null) {
            predicates.add(cb.equal(root.get("departure_time"), departureTime));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }

    @Override
    public RoundTripDto searchFlights(String departureAirport, String arrivalAirport, Date departureTime, Date returnTime) {
        Iterable<Flight> outboundFlights = searchFlights(departureAirport, arrivalAirport, departureTime);
        Iterable<Flight> inboundFlights = searchFlights(arrivalAirport, departureAirport, returnTime);
        return new RoundTripDto(outboundFlights, inboundFlights);
    }
}
