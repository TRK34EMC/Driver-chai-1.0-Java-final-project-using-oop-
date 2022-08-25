import javax.swing.*;
import java.awt.event.*;

import Login.*;
import User.*;
import Login.Signup;
import Dashboard.*;

public class Start {
  JFrame f;

  public static void main(String[] args) {

    JFrame f = new JFrame();

    // c1.customerLogin();
    // new CustomerSignUp();

    Customer[] blankc = new Customer[1];
    Driver[] blankd = new Driver[100];
    // new Login();
    // new CustomerDashboard(blankd);
    new Login(blankc, blankd);
    // new Dashboard();
    // new Signup();
  }
}
