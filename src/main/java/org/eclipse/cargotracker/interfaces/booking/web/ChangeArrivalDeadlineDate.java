package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles changing the cargo arrival deadline. Operates against a dedicated
 * service facade, mirroring the existing {@link ChangeDestination} pattern.
 * Completely separated from the domain layer.
 */
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String DATE_FORMAT = "MM/dd/yyyy";

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public CargoRoute getCargo() {
        return cargo;
    }

    public Date getArrivalDeadlineDate() {
        return arrivalDeadlineDate;
    }

    public void setArrivalDeadlineDate(Date arrivalDeadlineDate) {
        this.arrivalDeadlineDate = arrivalDeadlineDate;
    }

    void setBookingServiceFacade(BookingServiceFacade bookingServiceFacade) {
        this.bookingServiceFacade = bookingServiceFacade;
    }

    public void load() {
        cargo = bookingServiceFacade.loadCargoForRouting(trackingId);

        try {
            arrivalDeadlineDate = new SimpleDateFormat(DATE_FORMAT)
                    .parse(cargo.getArrivalDeadlineDate());
        } catch (ParseException e) {
            throw new RuntimeException(
                    "Error parsing arrival deadline date", e);
        }
    }

    public void changeArrivalDeadline() {
        if (arrivalDeadlineDate == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context != null) {
                FacesMessage message = new FacesMessage(
                        "Arrival deadline date is required.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, message);
            }
            return;
        }

        bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate);
        closeDialog();
    }

    /**
     * Closes the dynamic dialog on successful submission. Extracted so that
     * it can be overridden in container-free unit tests, where no
     * {@link PrimeFaces} instance is available.
     */
    void closeDialog() {
        PrimeFaces.current().dialog().closeDynamic("DONE");
    }
}
