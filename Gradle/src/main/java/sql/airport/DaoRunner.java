package sql.airport;

import sql.airport.DAO.TicketDao;
import sql.airport.DTO.TicketFilter;
import sql.airport.entity.TicketEntity;

import java.math.BigDecimal;

public class DaoRunner {
    public static void main(String[] args) {

        var ticket = TicketDao.getInstance().findById(5L);
        System.out.println(ticket);

//        saveTest();
//L
//        deleteTest(41L);

//        var ticketDao = TicketDao.getInstance();
//        var mayBeTicket = ticketDao.findById(2L);
//        System.out.println(mayBeTicket);
//
//        mayBeTicket.ifPresent(ticket -> {
//            ticket.setCost(BigDecimal.valueOf(2517.123));
//            ticketDao.update(ticket);
//        });

//        var allTickets = TicketDao.getInstance().findAll();
//        for (TicketEntity allTicket : allTickets) {
//            System.out.println(allTicket);
//        }

    }

    private static void filterTest() {
        var ticketFilter = new TicketFilter(10, 0,"Степан Дор", "A1");
        var tickets = TicketDao.getInstance().findAll(ticketFilter);
        System.out.println(tickets);
    }

    private static void deleteTest(Long id) {
        var ticketDao = TicketDao.getInstance();
        var deleteResult = ticketDao.delete(id);
        System.out.println(deleteResult);
    }

    private static void saveTest() {
        var ticketDao = TicketDao.getInstance();
        var ticket = new TicketEntity();
        ticket.setPassengerNo("1234567");
        ticket.setPassengerName("Test");
//        ticket.setFlightEntity(3L);
        ticket.setSeatNo("B3");
        ticket.setCost(BigDecimal.TEN);

        var savedTicket = ticketDao.save(ticket);
        System.out.println(savedTicket);
    }
}