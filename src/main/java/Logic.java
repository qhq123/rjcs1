import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Logic {
	Ticket ticket;
	boolean warning1;
	private ArrayList<Luggage> luglist;
	private ArrayList<SpeLuggage> speluglist; 
	private int [][]pricetable=new int[][] 
			{{},{0,380,980,980,1400},{0,280,690,690,1100},
		{0,520,520,520,520},{0,690,1040,1040,2050},{0,210,520,520,830}}; 
	private int [][]pricetable2=new int[][] 
				{{},{0,1400,2000,3000},{0,1100,1100,1590},
			{0,1170,1170,1590},{0,1380,1380,1590},{0,830,1100,1590}}; 
	private int []freeweighttable=new int[] {0,40,30,20,10};
	private int [][]freenumweight2table=new int[][] 
			{{},{0,0,32},{0,2,32},{0,2,23},{0,2,23},{0,1,23}};
	
	public Logic(Ticket ticket,ArrayList<Luggage> luglist,ArrayList<SpeLuggage> speluglist) {
		this.ticket=ticket;
		this.luglist=luglist;
		this.speluglist=speluglist;
		warning1=false;
	}
	public boolean isWarning1() {
		return warning1;
	}
	public ArrayList<Luggage> getLuglist() {
		return luglist;
	}
	public float caculate()
	{
		float charge=0;//����
		int freeweight=0;//����޶�(������)
		int freeweight2=0;//����޶�(�Ƽ���)
		int freenum=0;//��Ѽ���
		int overnum=0;//�������
		int region=0;
		int line=ticket.getLine();
		int passager=ticket.getPassager();
		int seat=ticket.getSeat();
		float price=ticket.getPrice();
		Ticket ticket=new Ticket(line,passager,seat,price);
		if(line==1)//����
		{	
			int a=ticket.freewei();
			freeweight=freeweighttable[a];
			
			//������������
			for(SpeLuggage temp:speluglist)
			{
				if(temp.getType()==11)//��äȮ
				{
					charge+=0;
				}
				else if(temp.getType()==21||temp.getType()==31)//������/˯��
				{
					if(temp.getWeight()<=freeweight)//����޶�����ʹ�������
					{
						freeweight-=temp.getWeight();
						charge+=0;
					}
					else//����޶����ʹ�������
					{
						float aweight=temp.getWeight()-freeweight;
						freeweight=0;
						charge+=aweight*0.015*price;
					}
				}
				else//(temp.getType()==22||temp.getType()==23||temp.getType()==32||temp.getType()==33||temp.getType()==34||temp.getType()==35)
					//Ƥ��ͧ/�Ÿ�/С�͵���/ǹ֧/�ӵ�/è��
				{
					charge+=temp.getWeight()*0.015*price;
				}
			}
			
			//����һ������
			for(Luggage temp:luglist)
			{
				if(temp.Issizefree())//������ѳߴ�
				{
					if(temp.getWeight()<=freeweight)//����޶�����ʹ�������
					{
						freeweight-=temp.getWeight();
						charge+=0;
					}
					else//����޶����ʹ�������
					{
						float aweight=temp.getWeight()-freeweight;
						freeweight=0;
						charge+=aweight*0.015*price;
					}
				}
				else//��������ѳߴ�
				{
					temp.setInvalid(true);
					warning1=true;
					charge+=0;
				}
			}
		}
		else//����
		{
			int b=ticket.freenumwei();
			freenum=freenumweight2table[b][1];
			freeweight2=freenumweight2table[b][2];
			if(line>=2 && line<4)//����һ
			{
				region=1;
			}
			else if(line>=4 && line<16)//�����
			{
				region=2;
			}
			else if(line>=16 && line<18)//������
			{
				region=3;
			}
			else if(line>=18 && line<21)//������
			{
				region=4;
			}
			else//������
			{
				region=5;
			}
			
			//������������
			for(SpeLuggage temp:speluglist)
			{
				
				if(temp.getType()==11)//��äȮ
				{
					charge+=0;
				}
				else if(temp.getType()==21||temp.getType()==31)//������/˯��
				{
					//�������
					int a=temp.ruletocharge(freeweight2);//����������Χ
					if(a==0) 
					{
						if(freenum>0) freenum-=1;
						else overnum+=1;
					}
					else 
					{
						charge+=pricetable[region][a];
						overnum+=1;
					}
				}
				else
				{
					if(temp.getType()==22)//Ƥ��ͧ
					{
						if(temp.getWeight()>=2 && temp.getWeight()<=23)
							charge+=2600;
						else if(temp.getWeight()>23 && temp.getWeight()<=32)
							charge+=3900;
						else 
							charge+=5200;
					}
					if(temp.getType()==23)//�Ÿ�
					{
						if(temp.getWeight()>=2 && temp.getWeight()<=23)
							charge+=1300;
						else if(temp.getWeight()>23 && temp.getWeight()<=32)
							charge+=2600;
						else 
							charge+=3900;
					}
					if(temp.getType()==32)//С�͵���
					{
						if(temp.getWeight()>=2 && temp.getWeight()<=23)
							charge+=490;
						else
							charge+=3900;
					}
					if(temp.getType()==33)//ǹ֧
					{
						if(temp.getWeight()>=2 && temp.getWeight()<=23)
							charge+=130;
						else
							charge+=2600;
					}
					if(temp.getType()==34)//�ӵ�
					{
						charge+=1300;
					}
					if(temp.getType()==35)//è��
					{
						if(temp.getWeight()>=2 && temp.getWeight()<=8)
							charge+=3900;
						else if(temp.getWeight()>8 && temp.getWeight()<=23)
							charge+=5200;
						else 
							charge+=7800;
					}
				}
			}
			
			//����һ������
			for(Luggage temp:luglist)
			{
				int a=temp.ruletocharge(freeweight2);//����������Χ
				if(a==0) 
				{
					if(freenum>0) freenum-=1;
					else overnum+=1;
				}
				else 
				{
					charge+=pricetable[region][a];
					overnum+=1;
				}
			}
		
			//���㳬����������
			if(overnum<=0)
				charge+=0;
			else if(overnum==1)
				charge+=pricetable2[region][1];
			else
				charge+=(pricetable2[region][1]+pricetable2[region][2]
						+pricetable2[region][3]*(overnum-2)); 
		}
		return charge;
	}
}
