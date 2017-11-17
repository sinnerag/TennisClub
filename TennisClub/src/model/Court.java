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
public class Court {

    private String courtId;
    private String courtName;
    private String courtType;
    private String courtLight;
    private String courtLocation;
    private String courtSurface;

    /**
     * @return the courtId
     */
    public String getCourtId() {
        return courtId;
    }

    /**
     * @param courtId the courtId to set
     */
    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    /**
     * @return the courtName
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * @param courtName the courtName to set
     */
    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    /**
     * @return the courtType
     */
    public String getCourtType() {
        return courtType;
    }

    /**
     * @param courtType the courtType to set
     */
    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }

    /**
     * @return the courtLight
     */
    public String getCourtLight() {
        return courtLight;
    }

    /**
     * @param courtLight the courtLight to set
     */
    public void setCourtLight(String courtLight) {
        this.courtLight = courtLight;
    }

    /**
     * @return the courtLocation
     */
    public String getCourtLocation() {
        return courtLocation;
    }

    /**
     * @param courtLocation the courtLocation to set
     */
    public void setCourtLocation(String courtLocation) {
        this.courtLocation = courtLocation;
    }

    /**
     * @return the courtSurface
     */
    public String getCourtSurface() {
        return courtSurface;
    }

    /**
     * @param courtSurface the courtSurface to set
     */
    public void setCourtSurface(String courtSurface) {
        this.courtSurface = courtSurface;
    }

}
