public class Ticket {
	int line;//����
	int passager;//�˿�����
	int seat;//��������
	float price;
	public Ticket(int line, int passager, int seat, float price) {
		this.line = line;
		this.passager = passager;
		this.seat = seat;
		this.price = price;
	}
	public int getLine() {
		return line;
	}
	public int getPassager() {
		return passager;
	}
	public int getSeat() {
		return seat;
	}
	public float getPrice() {
		return price;
	}
	public int freewei()
	{
		if(passager==1)//����/��ͯ
		{
			if(seat==1)//ͷ��
				return 1;
			else if(seat==2)//����
				return 2;
			else//����/�������á�����
				return 3;
		}
		else//Ӥ��
		{
			return 4;
		}
	}
	public int freenumwei()
	{
		if(passager==2 &&( seat==1 || seat==2))//Ӥ����ͷ�Ȳ�/�����
		{
			return 1;
		}
		else//����/��ͯ�����в�,Ӥ���ľ��ò�
		{
			if(seat==1 || seat==2)//ͷ��/����
			{
				return 2;
			}
			else//����/�������á�����
			{
				if(seat==3)//����/��������
				{
					return 3;
				}
				else//����
				{
					if(line==2||line==5||line==7||line==9||line==10||line==11||line==13
							||line==14||line==17||line==19||line==22||line==28)
						return 4;
					else
						return 5;
				}
			}
		}
	}
}
