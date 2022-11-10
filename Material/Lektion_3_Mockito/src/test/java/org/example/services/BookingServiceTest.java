package org.example.services;

import org.example.BookingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private RoomService roomService;
    private MailService mailService;
    private PaymentService paymentService;
    private BookingService bookingService;

    @BeforeEach
    public void setUp() {
        roomService = mock(RoomService.class);
        mailService = spy(MailService.class);
        paymentService = mock(PaymentService.class);
        bookingService = new BookingService(mailService, roomService, paymentService);
    }

    @Test
    public void twoPeopleOneNightIsOneHundred() {
        BookingRequest bookingRequest = new BookingRequest("1", 2, 1, false, "1");
        int expected = 50 * 2 * 1;
        int actual = bookingService.calculatePrice(bookingRequest);
        assertEquals(expected, actual);
    }

    @Test
    public void zeroAvailableRooms() {
        int availableRoomsCount = bookingService.getRoomService().getAvailableRooms().size();
        assertEquals(0, availableRoomsCount);
    }

    @Test
    public void oneAvailableRoom() {
        ArrayList<String> rooms = new ArrayList<>(Arrays.asList("1", "2", "3")); // Creating arraylist
        when(roomService.getAvailableRooms()).thenReturn(rooms); // Injecting arraylist to mock class
        int actual = bookingService.getRoomService().getAvailableRooms().size(); // Calling parent class to get child's arraylist
        assertEquals(3, actual);
    }

    @Test
    public void threeAvailableRooms() {
        when(roomService.getAvailableRoomsCount()).thenReturn(3);
        int actual = bookingService.getRoomService().getAvailableRoomsCount();
        assertEquals(3, actual);
    }

    @Test
    public void throwIllegalStateExceptionForGetRoomByIndex() {
        when(roomService.getRoomByIndex(anyInt())).thenThrow(IllegalStateException.class);
        Executable executable = () -> bookingService.getRoomService().getRoomByIndex(3);
        assertThrows(IllegalStateException.class, executable);
    }

    @Test
    public void getRoomByID(){
        when(roomService.getRoomByIndex(anyInt())).thenReturn("Room 1");
        String actual = bookingService.getRoomService().getRoomByIndex(12);
        assertEquals("Room 1", actual);
    }

    @Test
    public void shouldPayWhenPrepaid(){
        BookingRequest bookingRequest = new BookingRequest("1", 3, 2, true, "2");
        bookingService.bookRoom(bookingRequest);
        int amountToPay = bookingService.calculatePrice(bookingRequest);
        verify(paymentService).pay(amountToPay);
    }

    @Test
    public void shouldPayWhenPrepaidTwoBookings(){
        BookingRequest bookingRequest = new BookingRequest("1", 3, 2, true, "2");
        BookingRequest bookingRequest2 = new BookingRequest("1", 3, 2, true, "2");
        bookingService.bookRoom(bookingRequest);
        bookingService.bookRoom(bookingRequest2);
        verify(paymentService, times(2)).pay(anyInt());
    }
    @Test
    public void shouldNotPayWhenNotPrepaidTwoBookings(){
        BookingRequest bookingRequest = new BookingRequest("1", 3, 2, false, "2");
        BookingRequest bookingRequest2 = new BookingRequest("1", 3, 2, false, "2");
        bookingService.bookRoom(bookingRequest);
        bookingService.bookRoom(bookingRequest2);
        verify(paymentService, never()).pay(anyInt());
    }

    @Test
    public void shouldSendEmail(){
       String sendEmailMessage = bookingService.getMailService().sendEmail();
       System.out.println(sendEmailMessage);
    }

}