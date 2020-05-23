import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Caculator {

	private JFrame frame;
	private JFrame frame1;
	private JFrame frame2;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel p2;
	private JPanel p2_1; 
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	int type=0;
	String ty="";
	boolean warning1;
	
	private ArrayList<Luggage> luglist; 
	private ArrayList<SpeLuggage> speluglist; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caculator window = new Caculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Caculator() {
		initialize();
		luglist=new ArrayList<Luggage>();
		speluglist=new ArrayList<SpeLuggage>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("国航托运行李计算器");
		frame.setBounds(680, 230, 863, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setBorder(BorderFactory.createTitledBorder("机票信息"));
		p1.setBounds(14,23,245,228);
		frame.getContentPane().add(p1);
		p1.setLayout(null);
				
		p2=new JPanel();
		p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				input1();
			}
		});
		p2.setBorder(BorderFactory.createTitledBorder("普通行李"));
		p2.setBounds(273,23,374,228);
		frame.getContentPane().add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));
		
		p2_1 = new JPanel();
		p2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				input2();
			}
		});
		p2_1.setBorder(BorderFactory.createTitledBorder("特殊行李"));
		p2_1.setBounds(659, 23, 172, 228);
		frame.getContentPane().add(p2_1);
		p2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p3=new JPanel();
		p3.setBorder(BorderFactory.createTitledBorder("线路一览"));
		p3.setBounds(14,253,817,268);
		frame.getContentPane().add(p3);
		p3.setLayout(null);
		
		JLabel label1 = new JLabel("美洲(除美国、加拿大)↔欧洲、非洲、中东、亚洲、西南太平洋:线路1                          美洲内(除美国、加拿大):线路22");
		label1.setBounds(0, 26, 817, 18);
		p3.add(label1);
		JLabel label2 = new JLabel("美国(除夏威夷)↔美洲(除美国、加拿大):线路15                   美国（除夏威夷）↔加勒比海地区、欧洲、非洲、中东、亚洲、西南太平洋:线路16");
		label2.setBounds(0, 44, 817, 18);
		p3.add(label2);
		JLabel label3 = new JLabel("夏威夷↔美洲(除美国、加拿大)、加勒比海地区、欧洲、非洲、中东、亚洲、西南太平洋:线路17               夏威夷↔美国(本土)、加拿大:线路24");
		label3.setBounds(0, 61, 817, 18);
		p3.add(label3);
		JLabel label4 = new JLabel("加拿大↔美洲(除美国、加拿大)、加勒比海地区:线路13                加拿大↔欧洲、非洲、中东、亚洲、西南太平洋:线路14");
		label4.setBounds(0, 80, 817, 18);
		p3.add(label4);
		JLabel label5 = new JLabel("加勒比海区域↔欧洲、亚洲、西南太平洋:线路2                             加勒比海地区↔非洲、中东:线路27     加勒比海地区内:线路25");
		label5.setBounds(0, 98, 817, 18);
		p3.add(label5);
		JLabel label6 = new JLabel("欧洲↔非洲:线路3                     欧洲↔西南太平洋:线路4                欧洲↔亚洲(除日本、巴基斯坦、新加坡、哈萨克斯坦):线路5");
		label6.setBounds(0, 116, 817, 18);
		p3.add(label6);
		JLabel label7 = new JLabel("欧洲↔日本:线路6                     欧洲↔巴基斯坦、新加坡、哈萨克斯坦:线路7                      欧洲↔中东:线路21");
		label7.setBounds(0, 134, 817, 18);
		p3.add(label7);
		JLabel label8 = new JLabel("中东↔非洲、亚洲、西南太平洋:线路8                 日本↔西南太平洋:线路9                          日本↔非洲:线路12");
		label8.setBounds(0, 152, 817, 18);
		p3.add(label8);
		JLabel label9 = new JLabel("日本↔亚洲(除日本、西南太平洋、巴基斯坦、新加坡、哈萨克斯坦):线路10");
		label9.setBounds(0, 170, 817, 18);
		p3.add(label9);
		JLabel label10 = new JLabel("日本↔巴基斯坦、新加坡、哈萨克斯坦:线路11                                      巴基斯坦、新加坡、哈萨克斯坦之间:线路23");
		label10.setBounds(0, 188, 817, 18);
		p3.add(label10);
		JLabel label11 = new JLabel("西南太平洋↔亚洲(除日本、西南太平洋、巴基斯坦、新加坡、哈萨克斯坦)、非洲:线路13");
		label11.setBounds(0, 206, 817, 18);
		p3.add(label11);
		JLabel label12 = new JLabel("西南太平洋↔西南太平洋、巴基斯坦、新加坡、哈萨克斯坦:线路14                       非洲↔亚洲(除日本):线路20");
		label12.setBounds(0, 224, 817, 18);
		p3.add(label12);
		JLabel label13 = new JLabel("亚洲内(除日本、巴基斯坦、新加坡、哈萨克斯坦):线路22                                           其他线路 :线路28");
		label13.setBounds(0, 242, 817, 18);
		p3.add(label13);
		
		comboBox = new JComboBox();
		comboBox.setBounds(115, 43, 106, 24);
		p1.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(115, 88, 106, 24);
		p1.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(115, 133, 106, 24);
		p1.add(comboBox_2);
		
		textField = new JTextField();
		textField.setBounds(115, 178, 106, 24);
		p1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("航班路线");
		lblNewLabel.setBounds(33, 43, 60, 18);
		p1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("座舱类型");
		lblNewLabel_1.setBounds(33, 88, 60, 18);
		p1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("乘客类型");
		lblNewLabel_2.setBounds(33, 133, 60, 18);
		p1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("机票价格");
		lblNewLabel_3.setBounds(33, 178, 60, 18);
		p1.add(lblNewLabel_3);
		
		
		comboBox.addItem("--请选择--");
		comboBox.addItem("国内航班");
		comboBox.addItem("国际线路1");
		comboBox.addItem("国际线路2");
		comboBox.addItem("国际线路3");
		comboBox.addItem("国际线路4");
		comboBox.addItem("国际线路5");
		comboBox.addItem("国际线路6");
		comboBox.addItem("国际线路7");
		comboBox.addItem("国际线路8");
		comboBox.addItem("国际线路9");
		comboBox.addItem("国际线路10");
		comboBox.addItem("国际线路11");
		comboBox.addItem("国际线路12");
		comboBox.addItem("国际线路13");
		comboBox.addItem("国际线路14");
		comboBox.addItem("国际线路15");
		comboBox.addItem("国际线路16");
		comboBox.addItem("国际线路17");
		comboBox.addItem("国际线路18");
		comboBox.addItem("国际线路19");
		comboBox.addItem("国际线路20");
		comboBox.addItem("国际线路21");
		comboBox.addItem("国际线路22");
		comboBox.addItem("国际线路23");
		comboBox.addItem("国际线路24");
		comboBox.addItem("国际线路25");
		comboBox.addItem("国际线路26");
		comboBox.addItem("国际线路27");
		comboBox.addItem("国际线路28");
		
		
		comboBox_1.addItem("--请选择--");
		comboBox_1.addItem("头等舱");
		comboBox_1.addItem("公务舱");
		comboBox_1.addItem("悦享/超级经济舱");
		comboBox_1.addItem("经济舱");
		
		comboBox_2.addItem("--请选择--");
		comboBox_2.addItem("成人/儿童");
		comboBox_2.addItem("婴儿");
		
		JButton btnNewButton = new JButton("计算");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				caculate();
			}
		});
		btnNewButton.setBounds(296, 523, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(423, 523, 113, 27);
		frame.getContentPane().add(textField_1);

	}
	protected float checkticket(int line,int passager,int seat,String prices,
			ArrayList<SpeLuggage>speluglist,ArrayList<Luggage> luglist)
	{
		float price;
		Ticket ticket;
		if(line==0)
		{
			return -1;
		}
		if(passager==0)
		{
			return -2;
		}
		if(seat==0)
		{
			return -3;
		}
		if(prices.equals(""))
		{
			return -4;
		}
		try {
			price=Float.valueOf(prices);
			}
		catch(NumberFormatException e)
		{
			return -5;
		}
		if(price<=0)
		{
			return -6;
		}
		else 
		{
			price=Float.valueOf(prices);
			ticket=new Ticket(line,passager,seat,price);
			Logic caculator=new Logic(ticket,luglist,speluglist);
			float charge=caculator.caculate();
			warning1=caculator.isWarning1();
			luglist=caculator.getLuglist();
			return charge;
		}
	}
	protected void caculate() {
		// TODO Auto-generated method stub
		int line=comboBox.getSelectedIndex();//航线
		int passager=comboBox_2.getSelectedIndex();//乘客类型
		int seat=comboBox_1.getSelectedIndex();//座舱类型
		String prices=textField.getText();
		float charge=checkticket(line,passager,seat,prices,speluglist,luglist);
		if(charge==-1)
			JOptionPane.showMessageDialog(null, "请选择航班线路！", "warning",
					JOptionPane.WARNING_MESSAGE);
		else if(charge==-2)
			JOptionPane.showMessageDialog(null, "请选择乘客类型！", "warning",
				JOptionPane.WARNING_MESSAGE);
		if(charge==-3)
			JOptionPane.showMessageDialog(null, "请选择座舱类型！", "warning",
					JOptionPane.WARNING_MESSAGE);
		if(charge==-4)
			JOptionPane.showMessageDialog(null, "请输入价格！", "error",
					JOptionPane.WARNING_MESSAGE);
		if(charge==-5)
			JOptionPane.showMessageDialog(null, "格式错误，请输入数字！", "error",
					JOptionPane.ERROR_MESSAGE);
		if(charge==-6)
			JOptionPane.showMessageDialog(null, "机票价格需大于0！", "error",
					JOptionPane.WARNING_MESSAGE);
		else
		{
			if(warning1==true)
			{
				JOptionPane.showMessageDialog(null, "存在尺寸不符合标准!(长宽高不超过100,60,40)!未参与计算!", "warning",
					JOptionPane.WARNING_MESSAGE);
				p2.removeAll();
				for(Luggage temp:luglist)
				{
					String label="长:"+String.valueOf(temp.getLength())+" 宽:"+String.valueOf(temp.getWidth())+
						" 高:"+String.valueOf(temp.getHeight())+" 重:"+String.valueOf(temp.getWeight());
					JLabel jlabel=new JLabel(label);
					jlabel.setSize(300, 18);
					if(temp.isInvalid())
						jlabel.setForeground(Color.red);
					p2.add(jlabel);
				}
				p2.revalidate();
			}
			textField_1.setText(String.valueOf(charge));
		}
	}
	protected int input1re(String length,String width,String height,String weight)
	{
		float l = 0,w = 0,h = 0,wei = 0;
		if(length.equals("")||width.equals("")
				||height.equals("")||weight.equals(""))
			return 11;
		try {
		l=Float.valueOf(length);
		w=Float.valueOf(width);
		h=Float.valueOf(height);
		wei=Float.valueOf(weight);
		}
		catch(NumberFormatException e)
		{	
			return 12;
		}
		Luggage luggage=new Luggage(l, w, h, wei);
		if(!luggage.Issizevalid()||!luggage.Isweightvalid())
			if(!luggage.Issizevalid())
				return 2;
			else
				return 3;
		else 
			return 0;
	}
	protected void input1() {
		// TODO Auto-generated method stub
		frame1 =new JFrame("添加一般行李");
		frame1.setVisible(true);
		frame1.setBounds(680, 230, 520, 180);
		frame1.getContentPane().setLayout(null);
		
		JLabel jlabel1 = new JLabel("长(cm)");
		jlabel1.setBounds(50, 40, 40, 18);
		frame1.getContentPane().add(jlabel1);
		
		final JTextField textField1=new JTextField();
		textField1.setBounds(90, 40, 40, 24);
		frame1.getContentPane().add(textField1);
		textField1.setColumns(5);
		
		JLabel jlabel2 = new JLabel("宽(cm)");
		jlabel2.setBounds(160, 40, 40, 18);
		frame1.getContentPane().add(jlabel2);
		
		final JTextField textField2=new JTextField();
		textField2.setBounds(200, 40, 40, 24);
		frame1.getContentPane().add(textField2);
		textField2.setColumns(5);
		
		JLabel jlabel3 = new JLabel("高(cm)");
		jlabel3.setBounds(260, 40, 40, 18);
		frame1.getContentPane().add(jlabel3);
		
		final JTextField textField3=new JTextField();
		textField3.setBounds(300, 40, 40, 24);
		frame1.getContentPane().add(textField3);
		textField3.setColumns(5);
		
		JLabel jlabel4 = new JLabel("重(kg)");
		jlabel4.setBounds(360, 40, 40, 18);
		frame1.getContentPane().add(jlabel4);
		
		final JTextField textField4=new JTextField();
		textField4.setBounds(400, 40, 40, 24);
		frame1.getContentPane().add(textField4);
		textField4.setColumns(5);
		
		JButton jbutton1=new JButton("添加");
		jbutton1.setBounds(175, 80, 60, 28);
		frame1.getContentPane().add(jbutton1);
		jbutton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String length=textField1.getText();
				String width=textField2.getText();
				String height=textField3.getText();
				String weight=textField4.getText();
				int a=input1re(length,width,height,weight);
				if(a==11)
				{
					JOptionPane.showMessageDialog(null, "请输全信息！", "error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(a==12)
				{
					JOptionPane.showMessageDialog(null, "格式错误，请输入数字！", "error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(a==2)
						JOptionPane.showMessageDialog(null, "尺寸不符合规范(60~203cm)，请重新输入！", "warning",
								JOptionPane.WARNING_MESSAGE);
				else if(a==3)
						JOptionPane.showMessageDialog(null, "重量不符合规范(2~32kg)，请重新输入！", "warning",
								JOptionPane.WARNING_MESSAGE);
				else 
				{
					float l = 0,w = 0,h = 0,wei = 0;
					l=Float.valueOf(textField1.getText());
					w=Float.valueOf(textField2.getText());
					h=Float.valueOf(textField3.getText());
					wei=Float.valueOf(textField4.getText());
					Luggage luggage=new Luggage(l, w, h, wei);
					luglist.add(luggage);
					String label="长:"+String.valueOf(l)+" 宽:"+String.valueOf(w)+
						" 高:"+String.valueOf(h)+" 重:"+String.valueOf(wei);
					JLabel jlabel=new JLabel(label);
					jlabel.setSize(300, 18);
					p2.add(jlabel);
					p2.revalidate();
				}
			}
		});
		JButton jbutton2=new JButton("清空");
		jbutton2.setBounds(255, 80, 60, 28);
		frame1.getContentPane().add(jbutton2);
		jbutton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "确认清空?", "确认",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(result == JOptionPane.OK_OPTION)
                {
                    luglist.clear();
                    p2.removeAll();
                }
                p2.repaint();
			}
		});
	}
	protected int input2re(int select,String weight)
	{
		float wei = 0;
		if(weight.equals(""))
			return 11;
		try {
		wei=Float.valueOf(weight);
		}
		catch(NumberFormatException e)
		{	
			return 12;
		}
		type=0;
		ty="";
		if(select==0)
			return 2;
		else if(select==1)
		{type=11;ty="导盲犬";}
		else if(select==2)
		{type=21;ty="保龄球";}
		else if(select==3)
		{type=22;ty="皮划艇";}
		else if(select==4)
		{type=23;ty="撑杆";}
		else if(select==5)
		{type=31;ty="睡袋";}
		else if(select==6)
		{type=32;ty="小型电器";}
		else if(select==7)
		{type=33;ty="枪支";}
		else if(select==8)
		{type=34;ty="子弹";}
		else if(select==9)
		{type=35;ty="猫狗";}
		
		SpeLuggage speluggage=new SpeLuggage(wei,type);
		if(!speluggage.Isweightvalid())
		{
			if(type==22 ||type==23)
				return 3;
			else if(type==34)
				return 4;
			else
				return 5;
		}
		else return 0;
		
	}
	protected void input2() {
		// TODO Auto-generated method stub
		frame2 =new JFrame("添加特殊行李");
		frame2.setVisible(true);
		frame2.setBounds(680, 230, 380, 180);
		frame2.getContentPane().setLayout(null);
		
		JLabel jlabel1 = new JLabel("种类");
		jlabel1.setBounds(50, 40, 40, 18);
		frame2.getContentPane().add(jlabel1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 40, 80, 24);
		frame2.getContentPane().add(comboBox);
		comboBox.addItem("--请选择--");
		comboBox.addItem("导盲犬");
		comboBox.addItem("保龄球");
		comboBox.addItem("皮划艇");
		comboBox.addItem("撑杆");
		comboBox.addItem("睡袋");
		comboBox.addItem("小型电器");
		comboBox.addItem("枪支");
		comboBox.addItem("子弹");
		comboBox.addItem("猫狗");
		
		JLabel jlabel2 = new JLabel("重(kg)");
		jlabel2.setBounds(200, 40, 40, 18);
		frame2.getContentPane().add(jlabel2);
		
		final JTextField textField2=new JTextField();
		textField2.setBounds(240, 40, 40, 24);
		frame2.getContentPane().add(textField2);
		textField2.setColumns(5);
		
		JButton jbutton1=new JButton("添加");
		jbutton1.setBounds(110, 80, 60, 28);
		frame2.getContentPane().add(jbutton1);
		jbutton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				float wei = 0;
				int select=comboBox.getSelectedIndex();
				String weight=textField2.getText();
				int a=input2re(select,weight);
				if(a==11)
				{	JOptionPane.showMessageDialog(null, "请输入重量！", "error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(a==12)
				{	JOptionPane.showMessageDialog(null, "格式错误，请输入数字！", "error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(a==2)
				{
					JOptionPane.showMessageDialog(null, "请选择行李种类！", "warning",
							JOptionPane.WARNING_MESSAGE);
				}
				else if(a==3)
					JOptionPane.showMessageDialog(null, "重量不符合规范(2~45kg)，请重新输入！", "warning",
							JOptionPane.WARNING_MESSAGE);
				else if(a==4)
					JOptionPane.showMessageDialog(null, "重量不符合规范(2~5kg)，请重新输入！", "warning",
							JOptionPane.WARNING_MESSAGE);
				else if(a==5)
					JOptionPane.showMessageDialog(null, "重量不符合规范(2~32kg)，请重新输入！", "warning",
							JOptionPane.WARNING_MESSAGE);
				else
				{
					wei=Float.valueOf(textField2.getText());
					SpeLuggage speluggage=new SpeLuggage(wei,type);
					speluglist.add(speluggage);
					String label="特殊:"+ty+" 重:"+String.valueOf(wei);
					JLabel jlabel=new JLabel(label);
					jlabel.setSize(300, 18);
					p2_1.add(jlabel);
					p2_1.revalidate();
				}
			}
		});
		JButton jbutton2=new JButton("清空");
		jbutton2.setBounds(180, 80, 60, 28);
		frame2.getContentPane().add(jbutton2);
		jbutton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "确认清空?", "确认",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(result == JOptionPane.OK_OPTION)
                {
                    speluglist.clear();
                    p2_1.removeAll();
                }
                p2_1.repaint();
			}
		});
	}
}
