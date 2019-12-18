var departure_country_select;
var departure_city_select;

var arrival_country_select;
var arrival_city_select;

var reset_form_button;

$(document).ready(function () {

    departure_country_select = $("#departure_country");
    departure_country_select.on("change", () =>
        populateSelectWithCitiesByCountry(departure_country_select.val(), departure_city_select)
    );

    departure_city_select = $("#departure_city");

    arrival_country_select = $("#arrival_country");
    arrival_country_select.on("change", () =>
        populateSelectWithCitiesByCountry(arrival_country_select.val(), arrival_city_select)
    );

    arrival_city_select = $("#arrival_city");

    reset_form_button = $("#reset_form");
    reset_form_button.on("click", () => resetForm());

    $("td").on("click", ev => ev.preventDefault())
});

function populateSelectWithCitiesByCountry(country, selectToPopulate) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            selectToPopulate.empty();
            selectToPopulate.append($("<option selected hidden/>").val("").text("--"));
            citiesForCountry = this.responseText;
            $.each(JSON.parse(citiesForCountry), function () {
                selectToPopulate.append($("<option />").val(this).text(this));
            });
        }
    };
    xhr.open("GET", "city?country=" + country, true);
    xhr.send();
}

function selectFlight(flightNumber) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var flight = JSON.parse(this.responseText);
            populateModal(flight);
        }
    };
    xhr.open("GET", "flight?flightNumber=" + flightNumber, true);
    xhr.send();
}

function populateModal(flight) {
    $("#flightModalLabel").text(flight.flightNumber);
    $("#flightModalDepartureLocation").text(flight.departureCity.country + ', ' + flight.departureCity.name + ', lat. ' + flight.departureCity.latitude + ', long. ' + flight.departureCity.longitude);
    $("#flightModalDepartureTime").text(new Date(flight.departureDate).toLocaleString());
    $("#flightModalArrivalLocation").text(flight.arrivalCity.country + ', ' + flight.arrivalCity.name + ', lat. ' + flight.arrivalCity.latitude + ', long. ' + flight.arrivalCity.longitude);
    $("#flightModalArrivalTime").text(new Date(flight.arrivalDate).toLocaleString());

    var duration = new Date(flight.arrivalDate - flight.departureDate);

    $("#flightModalDuration").text(duration.getHours() + ':' + duration.getMinutes())
}

function resetForm() {
    departure_country_select.val("");
    departure_city_select.val("");
    arrival_country_select.val("");
    arrival_city_select.val("");
}
