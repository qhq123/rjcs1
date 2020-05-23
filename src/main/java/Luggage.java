public class Luggage {
	private float length;
	private float width;
	private float height;
	private float weight;
	private boolean invalid=false;
	public float getLength() {
		return length;
	}
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	public float getWeight() {
		return weight;
	}
	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}
	public boolean isInvalid() {
		return invalid;
	}
	private float sumof_a_b_h()
	{
		return length+width+height;
	}
	public Luggage(float length, float width, float height, float weight) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}
	public boolean Issizevalid()
	{
		if(sumof_a_b_h()>=60 && sumof_a_b_h()<=203)
			return true;
		else return false;
	}
	public boolean Isweightvalid()
	{
		if(weight>=2 && weight<=32)
			return true;
		else return false;
	}
	public boolean Issizefree()//������ѳߴ�
	{
		if(length<=100 && width<=60 && height<=40)
			return true;
		else return false;
	}
	public int ruletocharge(int freeweight)//0:δ���غͳ��ߴ� >1:���ػ򳬳ߴ�
	{
		if(freeweight==23)
		{
			if(sumof_a_b_h()>=60 && sumof_a_b_h()<=158 && weight>23 &&weight<=28)
				return 1;
			if(sumof_a_b_h()>=60 && sumof_a_b_h()<=158 && weight>28 &&weight<=32)
				return 2;
			if(sumof_a_b_h()>158 && sumof_a_b_h()<=203 && weight>2 &&weight<=23)
				return 3;
			if(sumof_a_b_h()>158 && sumof_a_b_h()<=203 && weight>23 &&weight<=32)
				return 4;
			else return 0;
		}
		else//(freeweight==32)
		{
			if(sumof_a_b_h()>158 && sumof_a_b_h()<=203)
				if(weight>=2 && weight<=23)
					return 3;
				else
					return 4;
			else return 0;
		}
	}
	
}
