package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.Location;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.RouteCandidate;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class ChangeArrivalDeadlineDateTest {

    @Test
    public void loadRequestsCorrectTrackingIdAndConvertsDate() throws ParseException {
        Date deadline = new SimpleDateFormat("MM/dd/yyyy").parse("12/25/2020");
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade(
                new CargoRoute("ABC123", "SEEEE", "USNYC", deadline, false,
                        false, "SEEEE", "NOT_RECEIVED"));
        ChangeArrivalDeadlineDate bean = new ChangeArrivalDeadlineDate();
        bean.setBookingServiceFacade(facade);
        bean.setTrackingId("ABC123");

        bean.load();

        assertEquals("ABC123", facade.loadedTrackingId);
        assertSame(facade.cargoRoute, bean.getCargo());
        assertEquals(dateOnly(deadline), dateOnly(bean.getArrivalDeadlineDate()));
    }

    @Test
    public void loadSurfacesMalformedDeadlineInsteadOfNull() {
        CargoRoute malformed = new CargoRoute("ABC123", "SEEEE", "USNYC",
                new Date(), false, false, "SEEEE", "NOT_RECEIVED") {
            private static final long serialVersionUID = 1L;

            @Override
            public String getArrivalDeadlineDate() {
                return "not-a-date";
            }
        };
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade(malformed);
        ChangeArrivalDeadlineDate bean = new ChangeArrivalDeadlineDate();
        bean.setBookingServiceFacade(facade);
        bean.setTrackingId("ABC123");

        try {
            bean.load();
            fail("Expected a RuntimeException to be thrown for a malformed deadline");
        } catch (RuntimeException e) {
            assertEquals(ParseException.class, e.getCause().getClass());
        }
        assertNull(bean.getArrivalDeadlineDate());
    }

    @Test
    public void changeArrivalDeadlineDelegatesToFacadeAndClosesDialog() {
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade(null);
        RecordingChangeArrivalDeadlineDate bean = new RecordingChangeArrivalDeadlineDate();
        bean.setBookingServiceFacade(facade);
        bean.setTrackingId("ABC123");
        Date selectedDate = new Date();
        bean.setArrivalDeadlineDate(selectedDate);

        bean.changeArrivalDeadline();

        assertEquals("ABC123", facade.changedTrackingId);
        assertSame(selectedDate, facade.changedDeadline);
        assertEquals(1, bean.closeDialogCalls);
    }

    @Test
    public void changeArrivalDeadlineRejectsNullDate() {
        RecordingBookingServiceFacade facade = new RecordingBookingServiceFacade(null);
        RecordingChangeArrivalDeadlineDate bean = new RecordingChangeArrivalDeadlineDate();
        bean.setBookingServiceFacade(facade);
        bean.setTrackingId("ABC123");
        bean.setArrivalDeadlineDate(null);

        bean.changeArrivalDeadline();

        assertFalse(facade.changeDeadlineCalled);
        assertEquals(0, bean.closeDialogCalls);
    }

    private static Date dateOnly(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private static class RecordingChangeArrivalDeadlineDate
            extends ChangeArrivalDeadlineDate {
        private static final long serialVersionUID = 1L;
        private int closeDialogCalls;

        @Override
        void closeDialog() {
            closeDialogCalls++;
        }
    }

    private static class RecordingBookingServiceFacade
            implements BookingServiceFacade {

        private final CargoRoute cargoRoute;
        private String loadedTrackingId;
        private boolean changeDeadlineCalled;
        private String changedTrackingId;
        private Date changedDeadline;

        RecordingBookingServiceFacade(CargoRoute cargoRoute) {
            this.cargoRoute = cargoRoute;
        }

        @Override
        public String bookNewCargo(String origin, String destination,
                                    Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            loadedTrackingId = trackingId;
            return cargoRoute;
        }

        @Override
        public void assignCargoToRoute(String trackingId, RouteCandidate route) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(String trackingId, String destinationUnLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            changeDeadlineCalled = true;
            changedTrackingId = trackingId;
            changedDeadline = arrivalDeadline;
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(String trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Location> listShippingLocations() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            throw new UnsupportedOperationException();
        }
    }
}
