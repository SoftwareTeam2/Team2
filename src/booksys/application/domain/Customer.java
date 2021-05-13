/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain ;

public class Customer
{
  private String name ;
  private String phoneNumber ;
  private boolean IsCar;
  
  public Customer(String n, String p, boolean Ic)
  {
    name = n ;
    phoneNumber = p ;
    IsCar = Ic;
  }

  public String getName()
  {
    return name ;
  }

  public String getPhoneNumber()
  {
    return phoneNumber ;
  }
  
  public boolean getIsCar() {
	  return IsCar;
  }
}
