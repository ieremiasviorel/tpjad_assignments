<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/client-home.js"></script>
    <link type="text/css" rel="stylesheet" href="css/client-home.css">

    <title>Flight Management System :: Home</title>
</head>
<body>

<form action="" method="post">
    <div class="departure">
        <h2>DEPARTURE</h2>
        <label for="departure_country">Country:</label>
        <select name="departure_country" id="departure_country">
            <option value="" selected hidden="true">--</option>
            <c:forEach items="${countries}" var="country">
                <option value="${country}" <c:if test="${country == flightFilter.departureCountry}">selected</c:if>>
                        ${country}
                </option>
            </c:forEach>
        </select>
        <label for="departure_city">City:</label>
        <select name="departure_city" id="departure_city">
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
        <input type="date" name="departure_date_start" id="departure_date_start"
               value="${flightFilter.departureStartDate}">
        <label for="departure_date_end">To:</label>
        <input type="date" name="departure_date_end" id="departure_date_end" value="${flightFilter.departureEndDate}">
    </div>

    <div class="arrival">
        <h2>ARRIVAL</h2>
        <label for="arrival_country">Country:</label>
        <select name="arrival_country" id="arrival_country">
            <option value="" selected hidden="true">--</option>
            <c:forEach items="${countries}" var="country">
                <option value="${country}" <c:if test="${country == flightFilter.arrivalCountry}">selected</c:if>>
                        ${country}
                </option>
            </c:forEach>
        </select>
        <label for="arrival_city">City:</label>
        <select name="arrival_city" id="arrival_city">
            <option value="" selected hidden="true">--</option>
            <c:if test="${arrivalCities != null}">
                <c:forEach items="${arrivalCities}" var="city">
                    <option value="${city.name}" <c:if test="${city.name == flightFilter.arrivalCity}">selected</c:if>>
                            ${city.name}
                    </option>
                </c:forEach>
            </c:if>
        </select>
    </div>
    <button type="submit">Search</button>
    <button type="reset">Reset</button>
</form>

<table id="flights-table">
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
        <tr class="flights-table-record" onClick="selectFlight('${flight.flightNumber}')">
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

<table id="flight-info-table">
    <tr>
        <th>Depature:</th>
    </tr>
    <tr>
        <td><p id="flight-info-departure-location"></p></td>
    </tr>
    <tr>
        <th>Arrival:</th>
    </tr>
    <tr>
        <td><p id="flight-info-arrival-location"></p></td>
    </tr>
</table>
</body>
</html>
