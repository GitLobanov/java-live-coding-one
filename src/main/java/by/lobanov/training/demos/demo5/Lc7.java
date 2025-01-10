package by.lobanov.training.demos.demo5;

import java.util.Collections;
import java.util.List;

public class Lc7 {


    public List<String> filterStrings(List<String> strings, int minLength) {
        if (strings == null) {
            return Collections.emptyList();
        }
        return strings.stream()
                .filter(word -> word != null && word.length() >= minLength)
                .toList();
    }

    public class PersonDto {

        public Long id;
        public String fullName;
        public int age;
        public String userName;
        public String password;

    }

//    @Service
//    @RequiredArgsConstructor
//    public class SeatBookingService {
//
//        private final SeatBookingRepository seatBookingRepository;
//        private TicketRepository ticketRepository;
//        private TariffClient tariffClient;
//        private CustomerClient customerClient;
//        private PaymentClient paymentClient;
//
//        //    Бронирование
////    @param seatCode код места (например 19А)
////    @param ticketId ид билета
//        @Transactional
//        public void bookSeat(String seatCode, UUID ticketId) {
//            var ticket = ticketRepository.findById(ticketId);
//            //бронируем
//            var seatBooking = new SeatBooking(seatCode, ticket.get().getFlightId(), ticketId, BoolingStatus.BOOKED);
//            seatBookingRepository.save(seatBooking);
//
//            //ищем базовый тариф для выбранного места в самолете
//            var basePrice = tariffClient.getBasePrice(ticket.get().getPlaneModel(), seatCode);
//            //ищем данные о клиенте
//            Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            var userData = customerClient.getCustomer(userId);
//            System.out.println("Найден пользователь " + userData.getFio() + " Номер документа " + userData.getDocument());
//            var price = basePrice;
//            if(userData.getTariff() == "PREMIUM") {
//                //скидка 50%
//                price = basePrice * 0.5d;
//            }
//            if(userData.getTariff() == "ULTRA") {
//                //скидка 20%
//                price = basePrice * 0.8d;
//            }
//            var invoce = new Invoce(price, ticketId, userId);
//            // выставляем платежку
//            paymentClient.sendInvoce(invoce);
//            System.out.println("Счет выставлен");
//        }
//
//
//
    }
