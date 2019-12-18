package com.tpjad.ejb.assig.beans;

import com.tpjad.ejb.assig.beans.interfaces.FlightServiceLocal;
import com.tpjad.ejb.assig.beans.interfaces.FlightServiceRemote;
import com.tpjad.ejb.assig.dtos.FlightFilter;
import com.tpjad.ejb.assig.entities.Flight;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FlightBeanImpl implements FlightServiceLocal, FlightServiceRemote {
    @PersistenceContext(unitName = "tpjad_assig2_ejb")
    private EntityManager manager;

    @Override
    public List<Flight> getAll() {
        TypedQuery<Flight> query = manager.createQuery("SELECT f FROM Flight f", Flight.class);
        return query.getResultList();
    }

    @Override
    public Flight getByFlightNumber(String flightNumber) {
        TypedQuery<Flight> query = manager.createQuery("SELECT f FROM Flight AS f WHERE f.flightNumber = :flightNumber", Flight.class);
        query.setParameter("flightNumber", flightNumber);
        return query.getSingleResult();
    }

    @Override
    public List<Flight> getByFilter(FlightFilter filter) {
        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append("SELECT f FROM Flight f JOIN f.departureCity depCity JOIN f.arrivalCity arrCity");

        List<String[]> predicateValues = new ArrayList<>();
        List<PredicateType> predicateTypes = new ArrayList<>();

        if (!filter.getDepartureCountry().isEmpty()) {
            predicateValues.add(new String[]{"depCity.country", filter.getDepartureCountry()});
            predicateTypes.add(PredicateType.EQUAL);
        }
        if (!filter.getDepartureCity().isEmpty()) {
            predicateValues.add(new String[]{"depCity.name", filter.getDepartureCity()});
            predicateTypes.add(PredicateType.EQUAL);
        }
        if (!filter.getArrivalCountry().isEmpty()) {
            predicateValues.add(new String[]{"arrCity.country", filter.getArrivalCountry()});
            predicateTypes.add(PredicateType.EQUAL);
        }
        if (!filter.getArrivalCity().isEmpty()) {
            predicateValues.add(new String[]{"arrCity.name", filter.getArrivalCity()});
            predicateTypes.add(PredicateType.EQUAL);
        }
        if (!filter.getDepartureStartDateStr().isEmpty()) {
            predicateValues.add(new String[]{"f.departureDate", filter.getDepartureStartDateStr()});
            predicateTypes.add(PredicateType.GREATER_THAN);
        }
        if (!filter.getDepartureEndDateStr().isEmpty()) {
            predicateValues.add(new String[]{"f.departureDate", filter.getDepartureEndDateStr()});
            predicateTypes.add(PredicateType.LESS_THAN);
        }
        if (!filter.getArrivalStartDateStr().isEmpty()) {
            predicateValues.add(new String[]{"f.arrivalDate", filter.getArrivalStartDateStr()});
            predicateTypes.add(PredicateType.GREATER_THAN);
        }
        if (!filter.getArrivalEndDateStr().isEmpty()) {
            predicateValues.add(new String[]{"f.arrivalDate", filter.getArrivalEndDateStr()});
            predicateTypes.add(PredicateType.LESS_THAN);
        }

        if (!predicateValues.isEmpty()) {
            queryStringBuilder.append(" WHERE ");
            queryStringBuilder.append(getQueryClause(predicateValues.get(0)[0], predicateValues.get(0)[1], predicateTypes.get(0)));

            for (int i = 1; i < predicateValues.size(); i++) {
                queryStringBuilder.append(" AND ");
                queryStringBuilder.append(getQueryClause(predicateValues.get(i)[0], predicateValues.get(i)[1], predicateTypes.get(i)));
            }
        }

        TypedQuery<Flight> query = manager.createQuery(queryStringBuilder.toString(), Flight.class);
        System.out.println(queryStringBuilder.toString());

        return query.getResultList();
    }

    private String getQueryClause(String fieldName, String fieldValue, PredicateType clauseType) {
        String op;
        switch (clauseType) {
            case LESS_THAN:
                op = " < ";
                break;
            case GREATER_THAN:
                op = " > ";
                break;
            default:
                op = " = ";
        }
        return fieldName + op + "'" + fieldValue + "'";
    }
}
