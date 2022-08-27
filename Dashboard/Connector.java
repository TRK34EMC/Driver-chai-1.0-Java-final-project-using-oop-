package Dashboard;
import java.lang.*;

import User.Customer;
import User.Driver;
import Login.Login;

public class Connector
{

  Customer authCus;
  Driver hiredDri;
  String workingHours;

  public Connector(Customer authCus , Driver hiredDri , String workingHours )
  {

  this.authCus = authCus;
  this.hiredDri = hiredDri;
  this.workingHours = workingHours;

  }


public Customer getAuthCus()
{

  return authCus;

}

public Driver  getHiredDri()
{

  return hiredDri;

}

public String  getHours()
{

  return workingHours;

}

}
