var departure_country_select;
var departure_city_select;

var arrival_country_select;
var arrival_city_select;

var flights_table;
var flight_info_table;

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

    flight_info_table = $("#flight-info-table");
    flight_info_table.hide();

    reset_form_button = $("#reset_form");
    reset_form_button.on("click", () => resetForm());
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
    xhr.open("GET", "cities?country=" + country, true);
    xhr.send();
}

function populateTableWithFlights() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    };
    var data = {
        "departure_city": departure_city_select.val(),
        "arrival_city": arrival_city_select.val(),
    };
    xhr.open("POST", "flights", true);
    xhr.send(JSON.stringify(data));
}

function selectFlight(flightNumber) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var flight = JSON.parse(this.responseText);
            $("#flight-info-departure-location").text(flight.departureCity.country + ", " + flight.departureCity.name);
            $("#flight-info-arrival-location").text(flight.arrivalCity.country + ", " + flight.arrivalCity.name);
            flight_info_table.show();
        }
    };
    xhr.open("GET", "flights?flightNumber=" + flightNumber, true);
    xhr.send();
}

function resetForm() {
    departure_country_select.val("");
    departure_city_select.val("");
    arrival_country_select.val("");
    arrival_city_select.val("");
}
