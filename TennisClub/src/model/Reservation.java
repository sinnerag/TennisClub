/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Anand
 */
public class Reservation {

    private String reservationId;
    private String reservationCourtId;
    private String reservationTime;
    private String reservationDate;
    private String reservationMemberId;

    /**
     * @return the reservationId
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * @return the reservationCourtId
     */
    public String getReservationCourtId() {
        return reservationCourtId;
    }

    /**
     * @param reservationCourtId the reservationCourtId to set
     */
    public void setReservationCourtId(String reservationCourtId) {
        this.reservationCourtId = reservationCourtId;
    }

    /**
     * @return the reservationTime
     */
    public String getReservationTime() {
        return reservationTime;
    }

    /**
     * @param reservationTime the reservationTime to set
     */
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    /**
     * @return the reservationDate
     */
    public String getReservationDate() {
        return reservationDate;
    }

    /**
     * @param reservationDate the reservationDate to set
     */
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * @return the reservationMemberId
     */
    public String getReservationMemberId() {
        return reservationMemberId;
    }

    /**
     * @param reservationMemberId the reservationMemberId to set
     */
    public void setReservationMemberId(String reservationMemberId) {
        this.reservationMemberId = reservationMemberId;
    }

    public boolean equalsIgnoreCase(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
