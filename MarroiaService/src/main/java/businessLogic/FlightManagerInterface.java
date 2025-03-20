package businessLogic;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import domain.ConcreteFlight;
import domain.Flight;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface FlightManagerInterface{
	@WebMethod
	public List<String> getAllDepartingCities();
	@WebMethod
	public List<String> getArrivalCitiesFrom(String departingCity);
	@WebMethod
	public Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date);
	@WebMethod
	public Flight getFlight(String flightCode);
	@WebMethod
	public List<Flight> getFlights();
	@WebMethod
	public ConcreteFlight getConcreteFlight(String concreFlightCode);
	//@WebMethod
	//public List<ConcreteFlight> getConcreteFlights2();
	@WebMethod
	public List<ConcreteFlight> getDateConcreteFlights(Date d);
	
	/* returns true if everything is OK, false if there is an error */
	@WebMethod
	public boolean bookSeat(ConcreteFlight cf, String type, int numOfSeatsToBook );

}