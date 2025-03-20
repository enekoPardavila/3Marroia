package client;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import service.*;

public class Main {
	public static void main(String[] args) {
	    FlightManagerService wsls = new FlightManagerService();
	    FlightManager facade = wsls.getFlightManagerPort();
	    
	    System.out.println("FLIGHT-AK BILATU ETA INPRIMATU");
	    List<Flight> listFlights = facade.getFlights();
	    
	    for (Flight f : listFlights) {
	        System.out.println("Flight: " + f.toString() + " eta bere ConcreteFlights:");
	        
	        for (ConcreteFlight cf : f.getConcreteFlights()) {
	            System.out.println(cf.toString() + " ");
	        }
	    }

	    System.out.println("CONCRETEFLIGHT-AK BILATU ETA INPRIMATU");
	    List<ConcreteFlight> listConcreteFlight = facade.getConcreteFlights2();
	    
	    for (ConcreteFlight cf : listConcreteFlight) {
	        System.out.println("ConcreteFlight: " + cf.toString() + " eta bere Flight " + cf.getFlight());
	    }

	    System.out.println("ConcreteFlights on " + newDate(2023, 1, 23).toString());
	    GregorianCalendar gc = new GregorianCalendar();
	    gc.setTime(newDate(2023, 1, 23));

	    try {
	        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	        List<ConcreteFlight> l = facade.getDateConcreteFlights(xmlDate);
	        
	        for (ConcreteFlight cf : l) {
	            System.out.println(cf.toString());
	        }
	    } catch (DatatypeConfigurationException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	private static XMLGregorianCalendar newDate(int year, int month, int day) {
		XMLGregorianCalendar calendar = XMLGregorianCalendar.getInstance();
	    calendar.set(year, month, day, 0, 0, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    return calendar.getTime();
	}
}
