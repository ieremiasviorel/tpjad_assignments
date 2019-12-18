<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/client-home.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/client-home.css">

    <title>Flight Management System :: Home</title>
</head>
<body>

<span value="${count}"></span>
<form action="" method="post">
    <div class="departure">
        <h2>DEPARTURE</h2>
        <label for="departure_country">Country:</label>
        <select name="departure_country" id="departure_country" class="form-control">
            <option value="" selected hidden="true">--</option>
            <c:forEach items="${countries}" var="country">
                <option value="${country}" <c:if test="${country == flightFilter.departureCountry}">selected</c:if>>
                        ${country}
                </option>
            </c:forEach>
        </select>
        <label for="departure_city">City:</label>
        <select name="departure_city" id="departure_city" class="form-control">
            <option value="" selected hidden="true">--</option>
            <c:if test="${departureCities != null}">
                <c:forEach items="${departureCities}" var="city">
                    <option value="${city.name}"
                            <c:if test="${city.name == flightFilter.departureCity}">selected</c:if>>
                            ${city.name}
                    </option>
                </c:forEach>
            </c:if>
        </select>
        <br>
        <label for="departure_date_start">From:</label>
        <input type="date" name="departure_date_start" id="departure_date_start" class="form-control"
               value="${flightFilter.departureStartDate}">
        <label for="departure_date_end">To:</label>
        <input type="date" name="departure_date_end" id="departure_date_end" class="form-control"
               value="${flightFilter.departureEndDate}">
    </div>

    <div class="arrival">
        <h2>ARRIVAL</h2>
        <label for="arrival_country">Country:</label>
        <select name="arrival_country" id="arrival_country" class="form-control">
            <option value="" selected hidden="true">--</option>
            <c:forEach items="${countries}" var="country">
                <option value="${country}" <c:if test="${country == flightFilter.arrivalCountry}">selected</c:if>>
                        ${country}
                </option>
            </c:forEach>
        </select>
        <label for="arrival_city">City:</label>
        <select name="arrival_city" id="arrival_city" class="form-control">
            <option value="" selected hidden="true">--</option>
            <c:if test="${arrivalCities != null}">
                <c:forEach items="${arrivalCities}" var="city">
                    <option value="${city.name}" <c:if test="${city.name == flightFilter.arrivalCity}">selected</c:if>>
                            ${city.name}
                    </option>
                </c:forEach>
            </c:if>
        </select>
        <br>
        <label for="arrival_date_start">From:</label>
        <input type="date" name="arrival_date_start" id="arrival_date_start" class="form-control"
               value="${flightFilter.arrivalStartDate}">
        <label for="arrival_date_end">To:</label>
        <input type="date" name="arrival_date_end" id="arrival_date_end" class="form-control"
               value="${flightFilter.arrivalEndDate}">
    </div>
    <button type="submit" class="btn btn-primary">Search</button>
    <button type="reset" class="btn btn-secondary">Reset</button>
</form>

<table id="flights-table" class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th>Flight number</th>
        <th>Airplane type</th>
        <th>Departure city</th>
        <th>Departure date</th>
        <th>Arrival city</th>
        <th>Arrival date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${flights}" var="flight">
        <tr class="flights-table-record" onClick="selectFlight('${flight.flightNumber}')"
            data-toggle="modal" data-target="#flightModal" value="${flight}">
            <td><c:out value="${flight.flightNumber}"/></td>
            <td><c:out value="${flight.airplaneType}"/></td>
            <td>
                <c:out value="${flight.departureCity.name}"/>,
                <c:out value="${flight.departureCity.country}"/>
            </td>
            <td><c:out value="${flight.departureDate}"/></td>
            <td>
                <c:out value="${flight.arrivalCity.name}"/>,
                <c:out value="${flight.arrivalCity.country}"/>
            </td>
            <td><c:out value="${flight.arrivalDate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

<div class="modal fade" id="flightModal" tabindex="-1" role="dialog" aria-labelledby="flightModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="flightModalLabel"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Departure</h6>
                <span id="flightModalDepartureLocation"></span>
                <br/>
                <span id="flightModalDepartureTime"></span>
                <h6>Arrival</h6>
                <span id="flightModalArrivalLocation"></span>
                <br/>
                <span id="flightModalArrivalTime"></span>
                <br/>
                <h6>Duration</h6>
                <span id="flightModalDuration"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
