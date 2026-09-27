package org.eclipse.cargotracker.interfaces.booking.facade.internal;

import org.eclipse.cargotracker.application.BookingService;
import org.eclipse.cargotracker.domain.model.cargo.Itinerary;
import org.eclipse.cargotracker.domain.model.cargo.TrackingId;
import org.eclipse.cargotracker.domain.model.location.UnLocode;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DefaultBookingServiceFacadeTest {

    @Test
    public void delegatesDeadlineChangeToBookingService() {
        RecordingBookingService bookingService = new RecordingBookingService();
        DefaultBookingServiceFacade facade
                = new DefaultBookingServiceFacade(bookingService);
        Date arrivalDeadline = new Date();

        facade.changeDeadline("ABC123", arrivalDeadline);

        assertEquals(1, bookingService.changeDeadlineCalls);
        assertEquals(new TrackingId("ABC123"), bookingService.trackingId);
        assertSame(arrivalDeadline, bookingService.arrivalDeadline);
    }

    private static class RecordingBookingService implements BookingService {
        private int changeDeadlineCalls;
        private TrackingId trackingId;
        private Date arrivalDeadline;

        @Override
        public TrackingId bookNewCargo(UnLocode origin, UnLocode destination,
                                       Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Itinerary> requestPossibleRoutesForCargo(TrackingId trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void assignCargoToRoute(Itinerary itinerary, TrackingId trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(TrackingId trackingId, UnLocode unLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDeadline(TrackingId trackingId, Date arrivalDeadline) {
            changeDeadlineCalls++;
            this.trackingId = trackingId;
            this.arrivalDeadline = arrivalDeadline;
        }
    }
}
