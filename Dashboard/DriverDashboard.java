package Dashboard;

import java.awt.*;
import java.awt.Color;
import javax.swing.ImageIcon;

import User.Customer;
import User.Driver;
import Login.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class DriverDashboard implements ActionListener
{

  JFrame driDashboardFrame;
  JPanel driverPanel1 , driverPanel2 , jobOffers , jobsp;
  JLabel background1 , background2 , cusName , cusPhone , carType , cDuration , cDurationl , cName , cNamel , cPhone , cPhonel , dp1 , dp2;
  JButton driLogout , bJobOffers , bBackToDriverPanel1 , bDriAccept , exit1 , exit2;
  String dServiceHour;
  JButton[] driAccept = new JButton[100];
  Driver[] drivers = new Driver[100];
  Customer[] customers = new Customer[100];
  Connector[] connectors = new Connector[100];
  Connector connector;

  public DriverDashboard(Driver[] drivers , Connector[] connectors)
  {

    this.drivers = drivers;
    this.connectors = connectors;

    driDashboardFrame =  new JFrame();
    driverPanel1 =  new JPanel();

    dp1 = new JLabel("Welcome Driver Chai");
    dp1.setBounds(410, 100, 300, 40);
    Font medFont = dp1.getFont().deriveFont(Font.PLAIN, 30f);
    dp1.setForeground(Color.BLACK);
    dp1.setFont(medFont);



    bJobOffers = new JButton("Check your job offers");
    bJobOffers.setBounds(450, 460, 250, 50);
    bJobOffers.addActionListener(this);
    bJobOffers.setOpaque(true);
    bJobOffers.setContentAreaFilled(true);
    bJobOffers.setBackground(Color.BLACK);
    bJobOffers.setBorderPainted(true);
    bJobOffers.setForeground(Color.WHITE);

    driLogout = new JButton("Logout");
    driLogout.setBounds(5, 600, 100, 40);
    driLogout.addActionListener(this);
    driLogout.setOpaque(true);
    driLogout.setContentAreaFilled(true);
    driLogout.setBackground(Color.BLACK);
    driLogout.setBorderPainted(true);
    driLogout.setForeground(Color.WHITE);

    exit1 = new JButton("Exit");
    exit1.setBounds(1000, 620, 80, 30);
    exit1.addActionListener(this);
    exit1.setOpaque(false);
    exit1.setContentAreaFilled(false);
    exit1.setBorderPainted(false);
    exit1.setForeground(Color.BLACK);

    ImageIcon img = new ImageIcon("Images/1.png");
    background1 = new JLabel(img);
    background1.setBounds(0, 0, 1100, 700);

    driverPanel1.add(bJobOffers);
    driverPanel1.add(driLogout);
    driverPanel1.add(exit1);
    driverPanel1.add(background1);
    driverPanel1.setLayout(null);
    driverPanel1.setBounds(0, 0, 1100, 700);
    driverPanel1.setBackground(Color.gray);
    driverPanel1.setVisible(true);

    /////////////////// job listing driver panel 2 //////////////////////

    driverPanel2 = new JPanel();

    dp2 = new JLabel("Your job offerings");
    dp2.setBounds(413, 20, 300, 40);
    dp2.setForeground(Color.BLACK);
    dp2.setFont(medFont);

    bBackToDriverPanel1 = new JButton("Back");
    bBackToDriverPanel1.setBounds(475, 580, 80, 40);
    bBackToDriverPanel1.addActionListener(this);
    bBackToDriverPanel1.setOpaque(true);
    bBackToDriverPanel1.setContentAreaFilled(true);
    bBackToDriverPanel1.setBackground(Color.BLACK);
    bBackToDriverPanel1.setBorderPainted(true);
    bBackToDriverPanel1.setForeground(Color.WHITE);

    exit2 = new JButton("Exit");
    exit2.setBounds(1000, 620, 80, 30);
    exit2.addActionListener(this);
    exit2.setOpaque(false);
    exit2.setContentAreaFilled(false);
    exit2.setBorderPainted(false);
    exit2.setForeground(Color.BLACK);

    jobOffers = new JPanel();

    jobOffers.setLayout(null);
    jobOffers.setBounds(260, 70, 600, 500);
    jobOffers.setBackground(Color.WHITE);
    jobOffers.setVisible(true);


    ImageIcon img2 = new ImageIcon("Images/2.png");
    background2 = new JLabel(img2);
    background2.setBounds(0, 0, 1100, 700);

    driverPanel2.add(dp2);
    driverPanel2.add(bBackToDriverPanel1);
    driverPanel2.add(exit2);
    driverPanel2.add(jobOffers);
    driverPanel2.add(background2);
    driverPanel2.setLayout(null);
    driverPanel2.setBounds(0, 0, 1100, 700);
    driverPanel2.setBackground(Color.gray);
    driverPanel2.setVisible(false);


    driDashboardFrame.add(driverPanel1);
    driDashboardFrame.add(driverPanel2);
    driDashboardFrame.setLayout(null);
    driDashboardFrame.setTitle("Dashboard - Driver Chai");
    driDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    driDashboardFrame.setSize(1100, 700);
    driDashboardFrame.setLocationRelativeTo(null);
    driDashboardFrame.setVisible(true);


  }


  public void jobListings(Connector connector , int i)
  {
    int pos = i * 110;

    Customer c = connector.getAuthCus();
    Driver d = connector.getHiredDri();
    String time = connector.getHours();



    jobsp = new JPanel();

    bDriAccept = new JButton("Accept");
    bDriAccept.setBounds(485, 32, 100, 27);
    bDriAccept.addActionListener(this);
    bDriAccept.setOpaque(true);
    bDriAccept.setContentAreaFilled(true);
    bDriAccept.setBackground(Color.BLACK);
    bDriAccept.setBorderPainted(true);
    bDriAccept.setForeground(Color.WHITE);


    cNamel = new JLabel("Customer Name: ");
    cNamel.setBounds(5, 5, 150, 20);
    cNamel.setForeground(Color.BLACK);

    cName = new JLabel(c.getName());
    cName.setBounds(100, 5, 200, 20);
    cName.setForeground(Color.BLACK);

    cPhonel = new JLabel("Phone: ");
    cPhonel.setBounds(5, 40, 200, 20);
    cPhonel.setForeground(Color.BLACK);

    cPhone = new JLabel(c.getPhoneNum());
    cPhone.setBounds(60, 40, 150, 20);
    cPhone.setForeground(Color.BLACK);

    cDurationl = new JLabel("Hiring duration: ");
    cDurationl.setBounds(5,75, 200, 20);
    cDurationl.setForeground(Color.BLACK);

    cDuration = new JLabel(time);
    cDuration.setBounds(100, 75, 150, 20);
    cDuration.setForeground(Color.BLACK);

    jobsp.add(bDriAccept);
    jobsp.add(cNamel);
    jobsp.add(cName);
    jobsp.add(cPhonel);
    jobsp.add(cPhone);
    jobsp.add(cDurationl);
    jobsp.add(cDuration);
    jobsp.setLayout(null);
    jobsp.setBounds(10, 10 + pos, 580, 100);
    jobsp.setBackground(new Color(244,200,85));
    jobsp.setVisible(true);

    jobOffers.add(jobsp);

    driAccept[i] = bDriAccept;

  }


public void actionPerformed(ActionEvent e) {


  for (int i = 0; i < driAccept.length; i++) {
    if (e.getSource() == driAccept[i])
    {

      JOptionPane.showMessageDialog(null, "Job Accepted!", "Success!",
      JOptionPane.WARNING_MESSAGE);

    }
  }

  if (e.getSource() == bJobOffers) {

    driverPanel2.setVisible(true);
    driverPanel1.setVisible(false);
    for (int i = 0; i < connectors.length; i++) {
      if (connectors[i] != null) {
        jobListings(connectors[i], i);

      }
    }
  }

  if (e.getSource() == bBackToDriverPanel1)
  {
    driverPanel2.setVisible(false);
    driverPanel1.setVisible(true);
  }
  if (e.getSource() == driLogout)
  {
    driDashboardFrame.setVisible(false);
    new Login(customers, drivers ,connectors);
  }

    if (e.getSource() == exit1)
    {
      System.exit(0);
    }

    if (e.getSource() == exit2)
    {
      System.exit(0);
    }


}
}
