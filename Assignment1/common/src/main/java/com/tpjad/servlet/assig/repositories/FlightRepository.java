package com.tpjad.servlet.assig.repositories;

import com.tpjad.servlet.assig.entities.Flight;
import com.tpjad.servlet.assig.utils.FlightFilter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightRepository {
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static List<Flight> flights = new ArrayList<Flight>();

    public List<Flight> findAll() {
        return flights;
    }

    public Flight findByFlightNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<Flight> findByFilter(FlightFilter filter) {
        return flights.stream()
                .filter(f -> filter.getDepartureCountry().isEmpty() || f.getDepartureCountry().equals(filter.getDepartureCountry()))
                .filter(f -> filter.getDepartureCity().isEmpty() || f.getDepartureCity().getName().equals(filter.getDepartureCity()))
                .filter(f -> filter.getArrivalCountry().isEmpty() || f.getArrivalCountry().equals(filter.getArrivalCountry()))
                .filter(f -> filter.getArrivalCity().isEmpty() || f.getArrivalCity().getName().equals(filter.getArrivalCity()))
                .filter(f -> filter.getDepartureStartDate() == null || f.getDepartureDate().after(filter.getDepartureStartDate()))
                .filter(f -> filter.getDepartureEndDate() == null || f.getDepartureDate().before(filter.getDepartureEndDate()))
                .collect(Collectors.toList());
    }

    static {
        try {
            flights.add(new Flight(1, "JAU-3683", "Airbus A350", CityRepository.findById(27), dateFormat.parse("2019-07-16 16:30:00"), CityRepository.findById(46), dateFormat.parse("2019-07-16 21:46:00")));
            flights.add(new Flight(2, "OMG-3893", "Boeing 767", CityRepository.findById(33), dateFormat.parse("2018-11-05 14:54:00"), CityRepository.findById(17), dateFormat.parse("2018-11-05 23:15:00")));
            flights.add(new Flight(3, "LBH-3576", "Airbus A220", CityRepository.findById(20), dateFormat.parse("2019-06-19 20:42:00"), CityRepository.findById(43), dateFormat.parse("2019-06-19 22:15:00")));
            flights.add(new Flight(4, "HCD-4508", "Boeing 707", CityRepository.findById(35), dateFormat.parse("2019-03-27 00:41:00"), CityRepository.findById(51), dateFormat.parse("2019-03-27 05:49:00")));
            flights.add(new Flight(5, "PFG-0690", "Boeing 777", CityRepository.findById(51), dateFormat.parse("2019-10-05 06:51:00"), CityRepository.findById(23), dateFormat.parse("2019-10-05 12:32:00")));
            flights.add(new Flight(6, "EEH-8576", "Boeing 757", CityRepository.findById(10), dateFormat.parse("2018-11-15 11:11:00"), CityRepository.findById(17), dateFormat.parse("2018-11-15 18:31:00")));
            flights.add(new Flight(7, "ZLJ-1073", "Airbus A220", CityRepository.findById(35), dateFormat.parse("2018-10-16 00:01:00"), CityRepository.findById(42), dateFormat.parse("2018-10-16 08:30:00")));
            flights.add(new Flight(8, "EWU-3512", "Airbus A380", CityRepository.findById(3), dateFormat.parse("2019-08-04 00:14:00"), CityRepository.findById(40), dateFormat.parse("2019-08-04 04:24:00")));
            flights.add(new Flight(9, "PNV-1396", "Boeing 767", CityRepository.findById(41), dateFormat.parse("2018-12-08 04:12:00"), CityRepository.findById(1), dateFormat.parse("2018-12-08 06:51:00")));
            flights.add(new Flight(10, "SEU-4665", "Boeing 777", CityRepository.findById(6), dateFormat.parse("2019-03-21 22:58:00"), CityRepository.findById(16), dateFormat.parse("2019-03-22 04:54:00")));
            flights.add(new Flight(11, "LJZ-6821", "Boeing 777", CityRepository.findById(48), dateFormat.parse("2019-08-02 20:36:00"), CityRepository.findById(10), dateFormat.parse("2019-08-03 04:46:00")));
            flights.add(new Flight(12, "SXG-9389", "Boeing 767", CityRepository.findById(15), dateFormat.parse("2019-01-23 19:00:00"), CityRepository.findById(41), dateFormat.parse("2019-01-24 02:48:00")));
            flights.add(new Flight(13, "VPO-2378", "Boeing 707", CityRepository.findById(46), dateFormat.parse("2019-03-31 22:41:00"), CityRepository.findById(19), dateFormat.parse("2019-04-01 00:00:00")));
            flights.add(new Flight(14, "UAB-5667", "Airbus A320", CityRepository.findById(39), dateFormat.parse("2019-01-31 22:59:00"), CityRepository.findById(52), dateFormat.parse("2019-02-01 07:28:00")));
            flights.add(new Flight(15, "IHR-5822", "Airbus A320", CityRepository.findById(18), dateFormat.parse("2018-11-15 19:55:00"), CityRepository.findById(41), dateFormat.parse("2018-11-15 22:41:00")));
            flights.add(new Flight(16, "HUK-7219", "Boeing 757", CityRepository.findById(23), dateFormat.parse("2019-04-22 00:12:00"), CityRepository.findById(48), dateFormat.parse("2019-04-22 08:37:00")));
            flights.add(new Flight(17, "GKC-7901", "Boeing 787", CityRepository.findById(9), dateFormat.parse("2019-08-20 10:21:00"), CityRepository.findById(1), dateFormat.parse("2019-08-20 14:34:00")));
            flights.add(new Flight(18, "UZR-7278", "Airbus A220", CityRepository.findById(3), dateFormat.parse("2019-08-12 02:26:00"), CityRepository.findById(34), dateFormat.parse("2019-08-12 10:08:00")));
            flights.add(new Flight(19, "SOS-7144", "Airbus A220", CityRepository.findById(42), dateFormat.parse("2019-03-15 16:23:00"), CityRepository.findById(41), dateFormat.parse("2019-03-15 23:32:00")));
            flights.add(new Flight(20, "JPZ-8161", "Airbus A350", CityRepository.findById(24), dateFormat.parse("2019-03-30 08:51:00"), CityRepository.findById(41), dateFormat.parse("2019-03-30 11:31:00")));
            flights.add(new Flight(21, "FCS-5402", "Boeing 777", CityRepository.findById(11), dateFormat.parse("2018-12-31 20:32:00"), CityRepository.findById(24), dateFormat.parse("2019-01-01 05:14:00")));
            flights.add(new Flight(22, "WSU-3184", "Boeing 737", CityRepository.findById(39), dateFormat.parse("2019-07-07 02:40:00"), CityRepository.findById(28), dateFormat.parse("2019-07-07 08:35:00")));
            flights.add(new Flight(23, "UCM-4683", "Boeing 787", CityRepository.findById(19), dateFormat.parse("2019-06-17 09:47:00"), CityRepository.findById(45), dateFormat.parse("2019-06-17 15:56:00")));
            flights.add(new Flight(24, "PAM-5584", "Boeing 757", CityRepository.findById(18), dateFormat.parse("2019-08-01 03:07:00"), CityRepository.findById(38), dateFormat.parse("2019-08-01 06:47:00")));
            flights.add(new Flight(25, "XYB-5631", "Boeing 777", CityRepository.findById(8), dateFormat.parse("2019-02-03 05:29:00"), CityRepository.findById(46), dateFormat.parse("2019-02-03 08:54:00")));
            flights.add(new Flight(26, "UID-1846", "Airbus A340", CityRepository.findById(44), dateFormat.parse("2019-02-10 18:51:00"), CityRepository.findById(28), dateFormat.parse("2019-02-10 23:06:00")));
            flights.add(new Flight(27, "JYC-5566", "Airbus A330", CityRepository.findById(27), dateFormat.parse("2019-02-03 22:06:00"), CityRepository.findById(10), dateFormat.parse("2019-02-04 02:24:00")));
            flights.add(new Flight(28, "DLF-1254", "Boeing 737", CityRepository.findById(2), dateFormat.parse("2019-08-18 02:39:00"), CityRepository.findById(26), dateFormat.parse("2019-08-18 06:09:00")));
            flights.add(new Flight(29, "DCM-5435", "Airbus A330", CityRepository.findById(32), dateFormat.parse("2019-02-02 00:42:00"), CityRepository.findById(9), dateFormat.parse("2019-02-02 04:24:00")));
            flights.add(new Flight(30, "IVL-9419", "Boeing 777", CityRepository.findById(16), dateFormat.parse("2019-06-04 18:23:00"), CityRepository.findById(39), dateFormat.parse("2019-06-04 23:41:00")));
            flights.add(new Flight(31, "OOD-9341", "Airbus A340", CityRepository.findById(8), dateFormat.parse("2018-11-06 19:37:00"), CityRepository.findById(43), dateFormat.parse("2018-11-07 00:50:00")));
            flights.add(new Flight(32, "SZJ-9183", "Boeing 757", CityRepository.findById(26), dateFormat.parse("2018-11-21 16:48:00"), CityRepository.findById(34), dateFormat.parse("2018-11-21 21:39:00")));
            flights.add(new Flight(33, "YER-6792", "Boeing 757", CityRepository.findById(12), dateFormat.parse("2018-11-17 18:26:00"), CityRepository.findById(16), dateFormat.parse("2018-11-18 01:30:00")));
            flights.add(new Flight(34, "NOI-3814", "Boeing 787", CityRepository.findById(24), dateFormat.parse("2019-03-08 11:29:00"), CityRepository.findById(8), dateFormat.parse("2019-03-08 19:08:00")));
            flights.add(new Flight(35, "BFX-6391", "Boeing 757", CityRepository.findById(42), dateFormat.parse("2019-07-03 00:18:00"), CityRepository.findById(7), dateFormat.parse("2019-07-03 03:10:00")));
            flights.add(new Flight(36, "UBJ-5125", "Airbus A350", CityRepository.findById(7), dateFormat.parse("2019-09-28 12:55:00"), CityRepository.findById(28), dateFormat.parse("2019-09-28 21:44:00")));
            flights.add(new Flight(37, "UKO-9420", "Airbus A350", CityRepository.findById(1), dateFormat.parse("2018-12-20 20:21:00"), CityRepository.findById(28), dateFormat.parse("2018-12-21 05:17:00")));
            flights.add(new Flight(38, "QRK-2071", "Boeing 757", CityRepository.findById(6), dateFormat.parse("2019-03-30 00:50:00"), CityRepository.findById(34), dateFormat.parse("2019-03-30 08:19:00")));
            flights.add(new Flight(39, "BDG-0658", "Boeing 727", CityRepository.findById(40), dateFormat.parse("2019-04-16 10:56:00"), CityRepository.findById(38), dateFormat.parse("2019-04-16 19:38:00")));
            flights.add(new Flight(40, "HTT-1338", "Airbus A380", CityRepository.findById(15), dateFormat.parse("2019-10-12 21:22:00"), CityRepository.findById(38), dateFormat.parse("2019-10-13 00:41:00")));
            flights.add(new Flight(41, "LFM-0982", "Boeing 767", CityRepository.findById(26), dateFormat.parse("2019-09-11 05:19:00"), CityRepository.findById(41), dateFormat.parse("2019-09-11 14:02:00")));
            flights.add(new Flight(42, "NNL-1826", "Boeing 767", CityRepository.findById(14), dateFormat.parse("2019-03-10 17:53:00"), CityRepository.findById(21), dateFormat.parse("2019-03-10 19:19:00")));
            flights.add(new Flight(43, "CPI-6661", "Boeing 707", CityRepository.findById(23), dateFormat.parse("2018-10-21 00:56:00"), CityRepository.findById(48), dateFormat.parse("2018-10-21 09:41:00")));
            flights.add(new Flight(44, "SIR-1190", "Boeing 737", CityRepository.findById(25), dateFormat.parse("2019-02-15 03:52:00"), CityRepository.findById(52), dateFormat.parse("2019-02-15 08:06:00")));
            flights.add(new Flight(45, "QCT-2976", "Boeing 737", CityRepository.findById(12), dateFormat.parse("2019-01-18 02:16:00"), CityRepository.findById(1), dateFormat.parse("2019-01-18 11:08:00")));
            flights.add(new Flight(46, "UIW-5141", "Boeing 777", CityRepository.findById(48), dateFormat.parse("2019-08-24 12:12:00"), CityRepository.findById(51), dateFormat.parse("2019-08-24 15:24:00")));
            flights.add(new Flight(47, "GWL-8841", "Boeing 767", CityRepository.findById(51), dateFormat.parse("2019-06-06 07:57:00"), CityRepository.findById(10), dateFormat.parse("2019-06-06 12:13:00")));
            flights.add(new Flight(48, "HUC-6690", "Boeing 757", CityRepository.findById(18), dateFormat.parse("2019-04-27 12:53:00"), CityRepository.findById(23), dateFormat.parse("2019-04-27 14:17:00")));
            flights.add(new Flight(49, "IDR-9911", "Airbus A350", CityRepository.findById(14), dateFormat.parse("2018-11-17 10:12:00"), CityRepository.findById(24), dateFormat.parse("2018-11-17 18:05:00")));
            flights.add(new Flight(50, "ERT-8480", "Airbus A220", CityRepository.findById(51), dateFormat.parse("2018-10-17 13:48:00"), CityRepository.findById(53), dateFormat.parse("2018-10-17 21:20:00")));
            flights.add(new Flight(51, "LLG-8721", "Airbus A220", CityRepository.findById(3), dateFormat.parse("2019-09-29 17:20:00"), CityRepository.findById(6), dateFormat.parse("2019-09-29 23:36:00")));
            flights.add(new Flight(52, "FGB-8125", "Airbus A340", CityRepository.findById(49), dateFormat.parse("2019-04-05 05:27:00"), CityRepository.findById(28), dateFormat.parse("2019-04-05 09:04:00")));
            flights.add(new Flight(53, "COR-9297", "Airbus A380", CityRepository.findById(27), dateFormat.parse("2019-03-30 07:13:00"), CityRepository.findById(41), dateFormat.parse("2019-03-30 13:31:00")));
            flights.add(new Flight(54, "MCC-4993", "Boeing 767", CityRepository.findById(32), dateFormat.parse("2019-09-30 15:27:00"), CityRepository.findById(29), dateFormat.parse("2019-09-30 16:57:00")));
            flights.add(new Flight(55, "LCN-4589", "Boeing 757", CityRepository.findById(26), dateFormat.parse("2019-03-15 17:32:00"), CityRepository.findById(54), dateFormat.parse("2019-03-16 02:56:00")));
            flights.add(new Flight(56, "NXH-6210", "Boeing 707", CityRepository.findById(53), dateFormat.parse("2019-04-07 10:35:00"), CityRepository.findById(38), dateFormat.parse("2019-04-07 14:42:00")));
            flights.add(new Flight(57, "DMG-8994", "Boeing 707", CityRepository.findById(31), dateFormat.parse("2019-07-21 21:28:00"), CityRepository.findById(44), dateFormat.parse("2019-07-22 06:32:00")));
            flights.add(new Flight(58, "XYN-0523", "Boeing 707", CityRepository.findById(25), dateFormat.parse("2019-01-04 07:07:00"), CityRepository.findById(39), dateFormat.parse("2019-01-04 13:06:00")));
            flights.add(new Flight(59, "OSA-7688", "Airbus A340", CityRepository.findById(20), dateFormat.parse("2019-01-28 11:48:00"), CityRepository.findById(5), dateFormat.parse("2019-01-28 17:06:00")));
            flights.add(new Flight(60, "JRH-3628", "Boeing 707", CityRepository.findById(42), dateFormat.parse("2019-09-03 20:20:00"), CityRepository.findById(11), dateFormat.parse("2019-09-04 02:17:00")));
            flights.add(new Flight(61, "TYW-5754", "Airbus A380", CityRepository.findById(30), dateFormat.parse("2018-10-16 16:32:00"), CityRepository.findById(28), dateFormat.parse("2018-10-16 22:39:00")));
            flights.add(new Flight(62, "WVA-8897", "Boeing 787", CityRepository.findById(12), dateFormat.parse("2019-01-17 15:07:00"), CityRepository.findById(53), dateFormat.parse("2019-01-17 18:24:00")));
            flights.add(new Flight(63, "MRN-5445", "Boeing 787", CityRepository.findById(16), dateFormat.parse("2019-08-01 16:07:00"), CityRepository.findById(30), dateFormat.parse("2019-08-01 19:21:00")));
            flights.add(new Flight(64, "UOY-6966", "Boeing 787", CityRepository.findById(7), dateFormat.parse("2019-01-21 18:10:00"), CityRepository.findById(38), dateFormat.parse("2019-01-21 23:08:00")));
            flights.add(new Flight(65, "SFH-9679", "Boeing 737", CityRepository.findById(14), dateFormat.parse("2018-10-15 16:11:00"), CityRepository.findById(22), dateFormat.parse("2018-10-15 18:59:00")));
            flights.add(new Flight(66, "PDS-0875", "Airbus A330", CityRepository.findById(5), dateFormat.parse("2018-11-11 14:34:00"), CityRepository.findById(53), dateFormat.parse("2018-11-11 19:02:00")));
            flights.add(new Flight(67, "ATD-1397", "Boeing 737", CityRepository.findById(36), dateFormat.parse("2019-03-14 02:14:00"), CityRepository.findById(34), dateFormat.parse("2019-03-14 10:22:00")));
            flights.add(new Flight(68, "JNG-3065", "Boeing 757", CityRepository.findById(40), dateFormat.parse("2018-12-12 02:25:00"), CityRepository.findById(21), dateFormat.parse("2018-12-12 06:26:00")));
            flights.add(new Flight(69, "SPP-2434", "Boeing 757", CityRepository.findById(30), dateFormat.parse("2019-09-10 00:48:00"), CityRepository.findById(47), dateFormat.parse("2019-09-10 09:21:00")));
            flights.add(new Flight(70, "FPF-4112", "Airbus A220", CityRepository.findById(30), dateFormat.parse("2018-11-21 07:20:00"), CityRepository.findById(26), dateFormat.parse("2018-11-21 08:42:00")));
            flights.add(new Flight(71, "CAK-5555", "Boeing 767", CityRepository.findById(38), dateFormat.parse("2019-03-08 05:02:00"), CityRepository.findById(24), dateFormat.parse("2019-03-08 12:44:00")));
            flights.add(new Flight(72, "HBA-0955", "Boeing 727", CityRepository.findById(21), dateFormat.parse("2019-04-15 01:53:00"), CityRepository.findById(45), dateFormat.parse("2019-04-15 07:37:00")));
            flights.add(new Flight(73, "SLO-9630", "Boeing 757", CityRepository.findById(3), dateFormat.parse("2018-11-13 22:43:00"), CityRepository.findById(19), dateFormat.parse("2018-11-14 05:48:00")));
            flights.add(new Flight(74, "MOX-3363", "Airbus A220", CityRepository.findById(49), dateFormat.parse("2019-05-22 00:20:00"), CityRepository.findById(7), dateFormat.parse("2019-05-22 03:00:00")));
            flights.add(new Flight(75, "JYZ-0342", "Boeing 737", CityRepository.findById(29), dateFormat.parse("2018-10-31 08:17:00"), CityRepository.findById(50), dateFormat.parse("2018-10-31 09:38:00")));
            flights.add(new Flight(76, "PVI-4926", "Airbus A350", CityRepository.findById(23), dateFormat.parse("2019-08-22 01:03:00"), CityRepository.findById(27), dateFormat.parse("2019-08-22 06:06:00")));
            flights.add(new Flight(77, "WGO-4267", "Airbus A350", CityRepository.findById(27), dateFormat.parse("2019-02-17 12:13:00"), CityRepository.findById(7), dateFormat.parse("2019-02-17 21:16:00")));
            flights.add(new Flight(78, "TEC-5793", "Boeing 777", CityRepository.findById(27), dateFormat.parse("2019-06-12 17:09:00"), CityRepository.findById(31), dateFormat.parse("2019-06-12 20:27:00")));
            flights.add(new Flight(79, "OJZ-1736", "Boeing 707", CityRepository.findById(37), dateFormat.parse("2019-01-09 18:29:00"), CityRepository.findById(9), dateFormat.parse("2019-01-10 04:29:00")));
            flights.add(new Flight(80, "BPF-2387", "Boeing 727", CityRepository.findById(7), dateFormat.parse("2019-05-02 14:27:00"), CityRepository.findById(31), dateFormat.parse("2019-05-02 19:27:00")));
            flights.add(new Flight(81, "XOO-7082", "Airbus A380", CityRepository.findById(47), dateFormat.parse("2019-08-23 16:10:00"), CityRepository.findById(36), dateFormat.parse("2019-08-23 20:39:00")));
            flights.add(new Flight(82, "LTP-0541", "Airbus A330", CityRepository.findById(47), dateFormat.parse("2018-10-25 17:00:00"), CityRepository.findById(35), dateFormat.parse("2018-10-25 18:10:00")));
            flights.add(new Flight(83, "OTH-7347", "Airbus A330", CityRepository.findById(25), dateFormat.parse("2019-09-09 19:40:00"), CityRepository.findById(43), dateFormat.parse("2019-09-10 01:48:00")));
            flights.add(new Flight(84, "CFR-2935", "Boeing 737", CityRepository.findById(30), dateFormat.parse("2019-04-21 03:32:00"), CityRepository.findById(53), dateFormat.parse("2019-04-21 13:02:00")));
            flights.add(new Flight(85, "BQU-0141", "Airbus A350", CityRepository.findById(38), dateFormat.parse("2019-02-23 08:53:00"), CityRepository.findById(33), dateFormat.parse("2019-02-23 12:12:00")));
            flights.add(new Flight(86, "CRE-4015", "Airbus A220", CityRepository.findById(13), dateFormat.parse("2019-08-10 03:12:00"), CityRepository.findById(46), dateFormat.parse("2019-08-10 12:48:00")));
            flights.add(new Flight(87, "TWW-4578", "Boeing 787", CityRepository.findById(17), dateFormat.parse("2018-12-21 03:16:00"), CityRepository.findById(10), dateFormat.parse("2018-12-21 07:42:00")));
            flights.add(new Flight(88, "OWJ-5464", "Boeing 767", CityRepository.findById(14), dateFormat.parse("2019-04-20 07:42:00"), CityRepository.findById(30), dateFormat.parse("2019-04-20 14:06:00")));
            flights.add(new Flight(89, "FVO-4299", "Boeing 767", CityRepository.findById(1), dateFormat.parse("2018-12-18 17:56:00"), CityRepository.findById(13), dateFormat.parse("2018-12-19 03:43:00")));
            flights.add(new Flight(90, "LBE-7973", "Airbus A220", CityRepository.findById(9), dateFormat.parse("2019-05-13 13:19:00"), CityRepository.findById(50), dateFormat.parse("2019-05-13 16:05:00")));
            flights.add(new Flight(91, "QRT-8657", "Airbus A220", CityRepository.findById(39), dateFormat.parse("2019-01-10 07:55:00"), CityRepository.findById(34), dateFormat.parse("2019-01-10 11:47:00")));
            flights.add(new Flight(92, "MSH-6694", "Airbus A350", CityRepository.findById(45), dateFormat.parse("2018-11-17 13:09:00"), CityRepository.findById(50), dateFormat.parse("2018-11-17 15:00:00")));
            flights.add(new Flight(93, "KLX-3738", "Airbus A330", CityRepository.findById(20), dateFormat.parse("2019-09-04 08:41:00"), CityRepository.findById(41), dateFormat.parse("2019-09-04 10:14:00")));
            flights.add(new Flight(94, "NBN-5767", "Boeing 757", CityRepository.findById(16), dateFormat.parse("2019-04-23 05:16:00"), CityRepository.findById(10), dateFormat.parse("2019-04-23 10:26:00")));
            flights.add(new Flight(95, "QIX-6556", "Boeing 787", CityRepository.findById(28), dateFormat.parse("2019-03-07 01:26:00"), CityRepository.findById(23), dateFormat.parse("2019-03-07 09:42:00")));
            flights.add(new Flight(96, "PVS-9356", "Boeing 767", CityRepository.findById(45), dateFormat.parse("2018-11-05 08:55:00"), CityRepository.findById(9), dateFormat.parse("2018-11-05 18:14:00")));
            flights.add(new Flight(97, "IRD-1509", "Boeing 767", CityRepository.findById(3), dateFormat.parse("2019-04-14 22:06:00"), CityRepository.findById(22), dateFormat.parse("2019-04-15 04:17:00")));
            flights.add(new Flight(98, "KDP-4525", "Boeing 787", CityRepository.findById(39), dateFormat.parse("2019-03-01 12:35:00"), CityRepository.findById(50), dateFormat.parse("2019-03-01 18:39:00")));
            flights.add(new Flight(99, "VVP-2101", "Boeing 727", CityRepository.findById(16), dateFormat.parse("2019-05-06 23:59:00"), CityRepository.findById(13), dateFormat.parse("2019-05-07 02:07:00")));
            flights.add(new Flight(100, "DOX-0661", "Boeing 737", CityRepository.findById(4), dateFormat.parse("2018-10-30 17:32:00"), CityRepository.findById(26), dateFormat.parse("2018-10-31 03:23:00")));
            flights.add(new Flight(101, "PEB-0164", "Airbus A320", CityRepository.findById(20), dateFormat.parse("2019-04-19 21:09:00"), CityRepository.findById(12), dateFormat.parse("2019-04-20 02:57:00")));
            flights.add(new Flight(102, "YTG-6244", "Airbus A320", CityRepository.findById(37), dateFormat.parse("2019-02-19 01:36:00"), CityRepository.findById(54), dateFormat.parse("2019-02-19 08:53:00")));
            flights.add(new Flight(103, "NRF-5856", "Boeing 737", CityRepository.findById(11), dateFormat.parse("2019-04-16 04:19:00"), CityRepository.findById(49), dateFormat.parse("2019-04-16 09:58:00")));
            flights.add(new Flight(104, "VLM-7754", "Boeing 777", CityRepository.findById(6), dateFormat.parse("2019-09-12 20:24:00"), CityRepository.findById(18), dateFormat.parse("2019-09-12 23:02:00")));
            flights.add(new Flight(105, "QAN-9807", "Airbus A350", CityRepository.findById(43), dateFormat.parse("2018-11-01 16:53:00"), CityRepository.findById(15), dateFormat.parse("2018-11-01 20:54:00")));
            flights.add(new Flight(106, "TXH-0507", "Boeing 707", CityRepository.findById(16), dateFormat.parse("2019-02-12 02:29:00"), CityRepository.findById(19), dateFormat.parse("2019-02-12 08:21:00")));
            flights.add(new Flight(107, "YEH-2877", "Boeing 707", CityRepository.findById(3), dateFormat.parse("2019-09-25 05:11:00"), CityRepository.findById(45), dateFormat.parse("2019-09-25 12:11:00")));
            flights.add(new Flight(108, "ANP-9056", "Boeing 727", CityRepository.findById(26), dateFormat.parse("2019-07-01 20:07:00"), CityRepository.findById(36), dateFormat.parse("2019-07-02 03:19:00")));
            flights.add(new Flight(109, "HZH-3789", "Airbus A340", CityRepository.findById(51), dateFormat.parse("2019-07-09 06:37:00"), CityRepository.findById(45), dateFormat.parse("2019-07-09 14:10:00")));
            flights.add(new Flight(110, "PRX-6496", "Boeing 757", CityRepository.findById(39), dateFormat.parse("2019-05-06 20:13:00"), CityRepository.findById(56), dateFormat.parse("2019-05-07 00:24:00")));
            flights.add(new Flight(111, "HDK-4556", "Boeing 757", CityRepository.findById(2), dateFormat.parse("2019-02-25 11:15:00"), CityRepository.findById(23), dateFormat.parse("2019-02-25 18:00:00")));
            flights.add(new Flight(112, "FMR-7896", "Boeing 707", CityRepository.findById(44), dateFormat.parse("2019-09-03 05:30:00"), CityRepository.findById(25), dateFormat.parse("2019-09-03 10:52:00")));
            flights.add(new Flight(113, "BNT-0208", "Airbus A380", CityRepository.findById(16), dateFormat.parse("2019-04-22 15:49:00"), CityRepository.findById(49), dateFormat.parse("2019-04-22 21:52:00")));
            flights.add(new Flight(114, "FRF-9971", "Airbus A330", CityRepository.findById(8), dateFormat.parse("2019-08-02 18:42:00"), CityRepository.findById(29), dateFormat.parse("2019-08-03 02:27:00")));
            flights.add(new Flight(115, "VDA-0436", "Boeing 757", CityRepository.findById(34), dateFormat.parse("2019-03-25 21:47:00"), CityRepository.findById(16), dateFormat.parse("2019-03-26 05:10:00")));
            flights.add(new Flight(116, "MST-2048", "Boeing 757", CityRepository.findById(5), dateFormat.parse("2018-12-05 21:19:00"), CityRepository.findById(26), dateFormat.parse("2018-12-05 22:20:00")));
            flights.add(new Flight(117, "PAH-7986", "Airbus A380", CityRepository.findById(35), dateFormat.parse("2019-01-23 11:05:00"), CityRepository.findById(48), dateFormat.parse("2019-01-23 16:22:00")));
            flights.add(new Flight(118, "SCI-7279", "Airbus A380", CityRepository.findById(11), dateFormat.parse("2019-01-25 11:41:00"), CityRepository.findById(47), dateFormat.parse("2019-01-25 18:52:00")));
            flights.add(new Flight(119, "XAB-7616", "Boeing 737", CityRepository.findById(22), dateFormat.parse("2018-11-07 06:04:00"), CityRepository.findById(55), dateFormat.parse("2018-11-07 11:51:00")));
            flights.add(new Flight(120, "OEV-0859", "Boeing 727", CityRepository.findById(38), dateFormat.parse("2019-05-28 11:07:00"), CityRepository.findById(31), dateFormat.parse("2019-05-28 21:06:00")));
            flights.add(new Flight(121, "HKG-9263", "Airbus A220", CityRepository.findById(5), dateFormat.parse("2019-05-15 10:39:00"), CityRepository.findById(55), dateFormat.parse("2019-05-15 11:48:00")));
            flights.add(new Flight(122, "XDN-1782", "Airbus A350", CityRepository.findById(41), dateFormat.parse("2019-02-25 18:33:00"), CityRepository.findById(28), dateFormat.parse("2019-02-25 20:30:00")));
            flights.add(new Flight(123, "FNB-7477", "Boeing 787", CityRepository.findById(43), dateFormat.parse("2019-03-10 06:51:00"), CityRepository.findById(36), dateFormat.parse("2019-03-10 08:37:00")));
            flights.add(new Flight(124, "BLD-5602", "Airbus A380", CityRepository.findById(35), dateFormat.parse("2018-12-19 03:03:00"), CityRepository.findById(47), dateFormat.parse("2018-12-19 08:59:00")));
            flights.add(new Flight(125, "PTN-4253", "Airbus A320", CityRepository.findById(34), dateFormat.parse("2019-01-31 11:05:00"), CityRepository.findById(31), dateFormat.parse("2019-01-31 14:57:00")));
            flights.add(new Flight(126, "DTR-0206", "Airbus A220", CityRepository.findById(13), dateFormat.parse("2019-07-20 21:12:00"), CityRepository.findById(8), dateFormat.parse("2019-07-21 06:39:00")));
            flights.add(new Flight(127, "IPO-6643", "Boeing 757", CityRepository.findById(10), dateFormat.parse("2018-12-14 00:49:00"), CityRepository.findById(30), dateFormat.parse("2018-12-14 08:14:00")));
            flights.add(new Flight(128, "VLO-6433", "Airbus A380", CityRepository.findById(22), dateFormat.parse("2019-05-25 23:04:00"), CityRepository.findById(11), dateFormat.parse("2019-05-26 07:28:00")));
            flights.add(new Flight(129, "LVY-2767", "Airbus A340", CityRepository.findById(42), dateFormat.parse("2019-05-07 10:59:00"), CityRepository.findById(2), dateFormat.parse("2019-05-07 18:58:00")));
            flights.add(new Flight(130, "PGP-5647", "Boeing 757", CityRepository.findById(33), dateFormat.parse("2019-02-17 17:07:00"), CityRepository.findById(49), dateFormat.parse("2019-02-17 21:47:00")));
            flights.add(new Flight(131, "UII-5941", "Boeing 777", CityRepository.findById(22), dateFormat.parse("2019-09-02 11:47:00"), CityRepository.findById(17), dateFormat.parse("2019-09-02 15:50:00")));
            flights.add(new Flight(132, "SIA-5562", "Boeing 757", CityRepository.findById(49), dateFormat.parse("2019-05-30 00:42:00"), CityRepository.findById(26), dateFormat.parse("2019-05-30 02:33:00")));
            flights.add(new Flight(133, "RGE-5192", "Airbus A350", CityRepository.findById(54), dateFormat.parse("2019-07-19 14:48:00"), CityRepository.findById(47), dateFormat.parse("2019-07-20 00:09:00")));
            flights.add(new Flight(134, "ZRK-7249", "Airbus A380", CityRepository.findById(15), dateFormat.parse("2019-10-10 04:49:00"), CityRepository.findById(24), dateFormat.parse("2019-10-10 07:47:00")));
            flights.add(new Flight(135, "XFG-9203", "Boeing 707", CityRepository.findById(39), dateFormat.parse("2019-07-07 12:08:00"), CityRepository.findById(18), dateFormat.parse("2019-07-07 19:11:00")));
            flights.add(new Flight(136, "CXE-7968", "Airbus A340", CityRepository.findById(50), dateFormat.parse("2019-04-21 01:25:00"), CityRepository.findById(40), dateFormat.parse("2019-04-21 05:34:00")));
            flights.add(new Flight(137, "BJB-8850", "Boeing 727", CityRepository.findById(17), dateFormat.parse("2018-12-18 23:09:00"), CityRepository.findById(35), dateFormat.parse("2018-12-19 00:50:00")));
            flights.add(new Flight(138, "AEW-4169", "Boeing 737", CityRepository.findById(30), dateFormat.parse("2019-08-17 19:40:00"), CityRepository.findById(48), dateFormat.parse("2019-08-17 23:59:00")));
            flights.add(new Flight(139, "KWS-0074", "Airbus A380", CityRepository.findById(14), dateFormat.parse("2019-07-21 23:19:00"), CityRepository.findById(48), dateFormat.parse("2019-07-22 04:54:00")));
            flights.add(new Flight(140, "VUU-2870", "Airbus A330", CityRepository.findById(7), dateFormat.parse("2019-06-18 08:06:00"), CityRepository.findById(47), dateFormat.parse("2019-06-18 15:26:00")));
            flights.add(new Flight(141, "EPA-8750", "Airbus A380", CityRepository.findById(19), dateFormat.parse("2019-08-14 01:30:00"), CityRepository.findById(49), dateFormat.parse("2019-08-14 11:10:00")));
            flights.add(new Flight(142, "PWG-1236", "Boeing 777", CityRepository.findById(16), dateFormat.parse("2018-12-13 04:09:00"), CityRepository.findById(8), dateFormat.parse("2018-12-13 12:16:00")));
            flights.add(new Flight(143, "XLI-1714", "Airbus A340", CityRepository.findById(50), dateFormat.parse("2019-05-18 22:27:00"), CityRepository.findById(48), dateFormat.parse("2019-05-19 01:41:00")));
            flights.add(new Flight(144, "UOM-6522", "Airbus A320", CityRepository.findById(50), dateFormat.parse("2019-05-06 23:42:00"), CityRepository.findById(18), dateFormat.parse("2019-05-07 03:32:00")));
            flights.add(new Flight(145, "GJF-5327", "Airbus A320", CityRepository.findById(30), dateFormat.parse("2018-12-28 03:50:00"), CityRepository.findById(24), dateFormat.parse("2018-12-28 07:35:00")));
            flights.add(new Flight(146, "AYB-7475", "Boeing 787", CityRepository.findById(2), dateFormat.parse("2018-10-15 03:16:00"), CityRepository.findById(41), dateFormat.parse("2018-10-15 11:35:00")));
            flights.add(new Flight(147, "QDQ-0751", "Boeing 777", CityRepository.findById(12), dateFormat.parse("2019-02-11 16:19:00"), CityRepository.findById(2), dateFormat.parse("2019-02-12 00:27:00")));
            flights.add(new Flight(148, "JSE-6092", "Boeing 707", CityRepository.findById(7), dateFormat.parse("2019-04-25 17:08:00"), CityRepository.findById(20), dateFormat.parse("2019-04-25 21:49:00")));
            flights.add(new Flight(149, "QJC-0472", "Airbus A380", CityRepository.findById(13), dateFormat.parse("2019-09-03 20:52:00"), CityRepository.findById(1), dateFormat.parse("2019-09-04 00:27:00")));
            flights.add(new Flight(150, "OEK-0718", "Airbus A380", CityRepository.findById(9), dateFormat.parse("2019-01-07 15:48:00"), CityRepository.findById(1), dateFormat.parse("2019-01-07 19:09:00")));
            flights.add(new Flight(151, "VYR-6183", "Boeing 707", CityRepository.findById(25), dateFormat.parse("2019-07-03 04:33:00"), CityRepository.findById(21), dateFormat.parse("2019-07-03 13:50:00")));
            flights.add(new Flight(152, "HMU-6425", "Airbus A320", CityRepository.findById(53), dateFormat.parse("2018-11-11 18:33:00"), CityRepository.findById(4), dateFormat.parse("2018-11-12 04:33:00")));
            flights.add(new Flight(153, "TOZ-6294", "Airbus A340", CityRepository.findById(45), dateFormat.parse("2019-04-17 18:12:00"), CityRepository.findById(24), dateFormat.parse("2019-04-17 19:33:00")));
            flights.add(new Flight(154, "ACR-6748", "Boeing 777", CityRepository.findById(40), dateFormat.parse("2019-04-04 02:54:00"), CityRepository.findById(30), dateFormat.parse("2019-04-04 11:03:00")));
            flights.add(new Flight(155, "BBS-9924", "Boeing 767", CityRepository.findById(26), dateFormat.parse("2019-04-19 19:06:00"), CityRepository.findById(37), dateFormat.parse("2019-04-20 03:25:00")));
            flights.add(new Flight(156, "AOU-1213", "Airbus A320", CityRepository.findById(6), dateFormat.parse("2018-12-17 23:26:00"), CityRepository.findById(28), dateFormat.parse("2018-12-18 03:50:00")));
            flights.add(new Flight(157, "KYB-2196", "Airbus A320", CityRepository.findById(40), dateFormat.parse("2019-05-04 04:02:00"), CityRepository.findById(6), dateFormat.parse("2019-05-04 07:18:00")));
            flights.add(new Flight(158, "BMX-8527", "Boeing 767", CityRepository.findById(49), dateFormat.parse("2019-09-18 06:59:00"), CityRepository.findById(17), dateFormat.parse("2019-09-18 09:37:00")));
            flights.add(new Flight(159, "RVO-9899", "Airbus A380", CityRepository.findById(46), dateFormat.parse("2019-08-14 03:48:00"), CityRepository.findById(15), dateFormat.parse("2019-08-14 12:19:00")));
            flights.add(new Flight(160, "FXC-0287", "Boeing 787", CityRepository.findById(2), dateFormat.parse("2018-10-23 04:05:00"), CityRepository.findById(18), dateFormat.parse("2018-10-23 08:52:00")));
            flights.add(new Flight(161, "JQX-0957", "Airbus A380", CityRepository.findById(3), dateFormat.parse("2018-12-16 11:19:00"), CityRepository.findById(19), dateFormat.parse("2018-12-16 17:16:00")));
            flights.add(new Flight(162, "APC-6765", "Airbus A350", CityRepository.findById(54), dateFormat.parse("2018-11-06 05:53:00"), CityRepository.findById(11), dateFormat.parse("2018-11-06 08:13:00")));
            flights.add(new Flight(163, "DTS-6106", "Airbus A330", CityRepository.findById(2), dateFormat.parse("2018-10-26 04:25:00"), CityRepository.findById(47), dateFormat.parse("2018-10-26 08:30:00")));
            flights.add(new Flight(164, "XIR-7787", "Airbus A340", CityRepository.findById(21), dateFormat.parse("2019-06-10 04:27:00"), CityRepository.findById(32), dateFormat.parse("2019-06-10 07:12:00")));
            flights.add(new Flight(165, "ILQ-3612", "Boeing 777", CityRepository.findById(43), dateFormat.parse("2019-09-24 15:43:00"), CityRepository.findById(23), dateFormat.parse("2019-09-24 18:15:00")));
            flights.add(new Flight(166, "KBY-0103", "Boeing 777", CityRepository.findById(15), dateFormat.parse("2019-02-24 02:42:00"), CityRepository.findById(10), dateFormat.parse("2019-02-24 12:04:00")));
            flights.add(new Flight(167, "XGP-1873", "Boeing 787", CityRepository.findById(5), dateFormat.parse("2018-12-11 11:20:00"), CityRepository.findById(17), dateFormat.parse("2018-12-11 18:45:00")));
            flights.add(new Flight(168, "ROO-4390", "Boeing 777", CityRepository.findById(26), dateFormat.parse("2018-10-22 12:29:00"), CityRepository.findById(3), dateFormat.parse("2018-10-22 19:08:00")));
            flights.add(new Flight(169, "HZQ-9642", "Boeing 767", CityRepository.findById(51), dateFormat.parse("2019-04-15 12:49:00"), CityRepository.findById(20), dateFormat.parse("2019-04-15 20:12:00")));
            flights.add(new Flight(170, "CGI-5956", "Boeing 757", CityRepository.findById(9), dateFormat.parse("2019-02-28 16:34:00"), CityRepository.findById(6), dateFormat.parse("2019-03-01 00:34:00")));
            flights.add(new Flight(171, "KPK-1188", "Airbus A340", CityRepository.findById(37), dateFormat.parse("2019-04-13 05:31:00"), CityRepository.findById(53), dateFormat.parse("2019-04-13 12:41:00")));
            flights.add(new Flight(172, "URL-9323", "Boeing 787", CityRepository.findById(12), dateFormat.parse("2018-11-04 02:43:00"), CityRepository.findById(55), dateFormat.parse("2018-11-04 11:12:00")));
            flights.add(new Flight(173, "JTG-9381", "Boeing 737", CityRepository.findById(11), dateFormat.parse("2018-12-04 08:06:00"), CityRepository.findById(16), dateFormat.parse("2018-12-04 13:48:00")));
            flights.add(new Flight(174, "YMR-9666", "Boeing 757", CityRepository.findById(15), dateFormat.parse("2019-03-19 10:24:00"), CityRepository.findById(17), dateFormat.parse("2019-03-19 20:00:00")));
            flights.add(new Flight(175, "GYE-2352", "Airbus A220", CityRepository.findById(24), dateFormat.parse("2018-11-04 17:06:00"), CityRepository.findById(40), dateFormat.parse("2018-11-05 01:30:00")));
            flights.add(new Flight(176, "ILN-9143", "Airbus A220", CityRepository.findById(55), dateFormat.parse("2019-07-25 06:44:00"), CityRepository.findById(31), dateFormat.parse("2019-07-25 13:34:00")));
            flights.add(new Flight(177, "XHB-1651", "Airbus A220", CityRepository.findById(1), dateFormat.parse("2019-06-15 23:52:00"), CityRepository.findById(52), dateFormat.parse("2019-06-16 01:01:00")));
            flights.add(new Flight(178, "PBI-5068", "Airbus A220", CityRepository.findById(27), dateFormat.parse("2018-11-23 00:09:00"), CityRepository.findById(49), dateFormat.parse("2018-11-23 06:53:00")));
            flights.add(new Flight(179, "VUT-7144", "Boeing 757", CityRepository.findById(49), dateFormat.parse("2019-02-03 19:33:00"), CityRepository.findById(55), dateFormat.parse("2019-02-04 05:19:00")));
            flights.add(new Flight(180, "FLX-6946", "Boeing 787", CityRepository.findById(51), dateFormat.parse("2019-08-21 13:22:00"), CityRepository.findById(14), dateFormat.parse("2019-08-21 19:33:00")));
            flights.add(new Flight(181, "TSH-8077", "Boeing 777", CityRepository.findById(50), dateFormat.parse("2018-10-24 03:19:00"), CityRepository.findById(7), dateFormat.parse("2018-10-24 06:06:00")));
            flights.add(new Flight(182, "GMA-2287", "Airbus A350", CityRepository.findById(6), dateFormat.parse("2019-03-12 05:20:00"), CityRepository.findById(26), dateFormat.parse("2019-03-12 11:43:00")));
            flights.add(new Flight(183, "OJD-9820", "Airbus A330", CityRepository.findById(46), dateFormat.parse("2019-03-24 00:31:00"), CityRepository.findById(27), dateFormat.parse("2019-03-24 08:52:00")));
            flights.add(new Flight(184, "TKG-6967", "Boeing 787", CityRepository.findById(21), dateFormat.parse("2019-02-07 18:50:00"), CityRepository.findById(34), dateFormat.parse("2019-02-07 22:41:00")));
            flights.add(new Flight(185, "OIE-9331", "Airbus A320", CityRepository.findById(15), dateFormat.parse("2019-05-16 13:45:00"), CityRepository.findById(56), dateFormat.parse("2019-05-16 16:42:00")));
            flights.add(new Flight(186, "CHP-9091", "Airbus A220", CityRepository.findById(25), dateFormat.parse("2018-10-27 22:12:00"), CityRepository.findById(34), dateFormat.parse("2018-10-28 04:52:00")));
            flights.add(new Flight(187, "EZN-3808", "Boeing 767", CityRepository.findById(20), dateFormat.parse("2019-04-16 01:44:00"), CityRepository.findById(31), dateFormat.parse("2019-04-16 06:18:00")));
            flights.add(new Flight(188, "WDQ-9598", "Boeing 737", CityRepository.findById(3), dateFormat.parse("2019-08-08 17:26:00"), CityRepository.findById(20), dateFormat.parse("2019-08-09 02:14:00")));
            flights.add(new Flight(189, "GFS-2687", "Airbus A340", CityRepository.findById(6), dateFormat.parse("2019-05-17 15:16:00"), CityRepository.findById(35), dateFormat.parse("2019-05-17 17:33:00")));
            flights.add(new Flight(190, "IDJ-7214", "Airbus A220", CityRepository.findById(22), dateFormat.parse("2019-08-30 21:21:00"), CityRepository.findById(5), dateFormat.parse("2019-08-30 22:49:00")));
            flights.add(new Flight(191, "CEH-5012", "Boeing 777", CityRepository.findById(45), dateFormat.parse("2019-10-06 11:27:00"), CityRepository.findById(31), dateFormat.parse("2019-10-06 18:07:00")));
            flights.add(new Flight(192, "KCG-6025", "Boeing 707", CityRepository.findById(48), dateFormat.parse("2019-06-22 09:24:00"), CityRepository.findById(39), dateFormat.parse("2019-06-22 11:26:00")));
            flights.add(new Flight(193, "HXE-7768", "Boeing 727", CityRepository.findById(39), dateFormat.parse("2019-04-18 17:31:00"), CityRepository.findById(33), dateFormat.parse("2019-04-18 20:00:00")));
            flights.add(new Flight(194, "CNI-0422", "Airbus A340", CityRepository.findById(21), dateFormat.parse("2019-04-10 09:44:00"), CityRepository.findById(12), dateFormat.parse("2019-04-10 11:37:00")));
            flights.add(new Flight(195, "JRA-9656", "Airbus A220", CityRepository.findById(32), dateFormat.parse("2019-10-03 02:50:00"), CityRepository.findById(46), dateFormat.parse("2019-10-03 12:50:00")));
            flights.add(new Flight(196, "MKQ-4920", "Airbus A350", CityRepository.findById(1), dateFormat.parse("2019-04-05 18:36:00"), CityRepository.findById(39), dateFormat.parse("2019-04-05 20:21:00")));
            flights.add(new Flight(197, "HUA-7700", "Boeing 787", CityRepository.findById(33), dateFormat.parse("2019-02-16 18:02:00"), CityRepository.findById(47), dateFormat.parse("2019-02-16 22:32:00")));
            flights.add(new Flight(198, "OUH-1780", "Airbus A350", CityRepository.findById(41), dateFormat.parse("2018-10-28 10:05:00"), CityRepository.findById(34), dateFormat.parse("2018-10-28 13:31:00")));
            flights.add(new Flight(199, "ZPP-3356", "Airbus A330", CityRepository.findById(25), dateFormat.parse("2019-01-22 13:53:00"), CityRepository.findById(6), dateFormat.parse("2019-01-22 23:01:00")));
            flights.add(new Flight(200, "ALB-9013", "Boeing 727", CityRepository.findById(32), dateFormat.parse("2019-07-21 02:35:00"), CityRepository.findById(48), dateFormat.parse("2019-07-21 09:05:00")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
