package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import data.user.VIPCustomer;

public class VIPDialog extends JDialog implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer timer=new Timer(1500,this);
	VIPCustomer vip;
	
	public VIPDialog(VIPCustomer vip)
	{
		super();
		this.vip=vip;
		init();
		setSize(300,300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		timer.start();
	}
	
	void init()
	{
		setLayout(null);
		setTitle("欢迎VIP顾客光临");
		
		JLabel welcome=new JLabel("Welcome vip!");
		welcome.setFont(new Font("Arial",Font.BOLD,24));
		
		add(welcome);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setBounds(30,30,200,40);
		
		
		JLabel IDjlb=new JLabel("VIP账号:");
		JLabel leftPointjlb=new JLabel("VIP可用积分:");
		JLabel totalPointjlb=new JLabel("VIP总积分:");
		JLabel gradejlb=new JLabel("VIP等级");
		JLabel IDField=new JLabel();
		JLabel leftPointField=new JLabel();
		JLabel totalPointField=new JLabel();
		JLabel gradeField=new JLabel();
		
		IDField.setText(vip.getID());
		totalPointField.setText(String.valueOf(vip.getPoint()));
		gradeField.setText(String.valueOf(vip.getGrade()));
		leftPointField.setText(String.valueOf(vip.getleft_point()));
		
		
		add(IDjlb);
		IDjlb.setBounds(50,100, 100, 30);
		add(IDField);
		IDField.setBounds(180,100,100,30);
		add(leftPointjlb);
		leftPointjlb.setBounds(50,130,100,30);
		add(leftPointField);
		leftPointField.setBounds(180,130,100,30);
		add(totalPointjlb);
		totalPointjlb.setBounds(50,160,100,30);
		add(totalPointField);
		totalPointField.setBounds(180,160,100,30);
		add(gradejlb);
		gradejlb.setBounds(50,190,100,30);
		add(gradeField);
		gradeField.setBounds(180,190,100,30);
		
	}
	public void actionPerformed(ActionEvent e) {
		timer.stop();
		dispose();
	}
}
