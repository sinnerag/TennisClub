/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Court;
import model.Member;
import model.Reservation;

/**
 *
 * @author Anand
 */
public class AvailableLists {
    static int memberid=4;
    static int courtId=4;
    static int reservationId=4;
   static  List<Member>  memberList = new ArrayList<Member>();
   static List<Court> courtList=new  ArrayList<Court>();
   static List<Reservation> reservationList=new ArrayList<Reservation>();
    static{
          Member m=new Member();
          m.setId("1");
          m.setName("XYZ");
          m.setMobile("65679586");
          m.setEmail("xys@gmail.com");
          m.setAddress("hfdhgfjghgfhk");
          memberList.add(m);
          Member m1=new Member();
          m1.setId("2");
          m1.setName("wqer");
          m1.setMobile("987635634");
          m1.setEmail("abc@gmail.com");
          m1.setAddress("sfhdvbfkgkjgf");
          memberList.add(m1);
          Member m2=new Member();
          m2.setId("3");
          m2.setName("sckdsf");
          m2.setMobile("34234456577");
          m2.setEmail("sdsaf@gmail.com");
          m2.setAddress("fsdgfhgj");
          memberList.add(m2);
          
          
          Court c=new Court();
          c.setCourtId("1");
          c.setCourtName("abc");
          c.setCourtType("outdooor");
          c.setCourtLight("yes");
          c.setCourtSurface("grass");
          c.setCourtLocation("dggvf");
          courtList.add(c);
           Court c1=new Court();
          c1.setCourtId("2");
          c1.setCourtName("dsfds");
          c1.setCourtType("indoor");
          c1.setCourtLight("no");
          c1.setCourtSurface("hard");
          c1.setCourtLocation("dffhds");
          courtList.add(c1);
           Court c2=new Court();
          c2.setCourtId("3");
          c2.setCourtName("sfggh");
          c2.setCourtType("outdooor");
          c2.setCourtLight("no");
          c2.setCourtSurface("grass");
          c2.setCourtLocation("dsafdsgffg");
          courtList.add(c2);
          
          Reservation r=new Reservation();
          r.setReservationId("1");
          r.setReservationCourtId("1");
          r.setReservationTime("09:00");
          r.setReservationDate("23-09-2016");
          r.setReservationMemberId("1");
          getReservationList().add(r);
          
          Reservation r1=new Reservation();
          r1.setReservationId("2");
          r1.setReservationCourtId("2");
          r1.setReservationTime("10:00");
          r1.setReservationDate("23-09-2016");
          r1.setReservationMemberId("2");
          getReservationList().add(r1);
          
          Reservation r2=new Reservation();
          r2.setReservationId("3");
          r2.setReservationCourtId("1");
          r2.setReservationTime("11:00");
          r2.setReservationDate("24-09-2016");
          r2.setReservationMemberId("3");
          getReservationList().add(r2);
          
    }

    /**
     * @return the reservationList
     */
    public static List<Reservation> getReservationList() {
        return reservationList;
    }

    /**
     * @param aReservationList the reservationList to set
     */
    public static void setReservationList(List<Reservation> aReservationList) {
        reservationList = aReservationList;
    }
    
}
