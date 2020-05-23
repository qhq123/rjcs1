public class SpeLuggage {
	private float weight;
	private int type;
	public float getWeight() {
		return weight;
	}
	public int getType() {
		return type;
	}
	public SpeLuggage(float weight, int type) {
		this.weight = weight;
		this.type = type;
	}
	public boolean Isweightvalid()
	{
		if((type==22 ||type==23)&&( (weight>=2)&&(weight<=45)))
			return true;
		else if((type==34) &&( (weight>=2)&&(weight<=5)))
			return true;
		else if((type!=22&&type!=23&&type!=34)&&(weight>=2)&&(weight<=32))
			return true;
		else return false;
	}
	public int ruletocharge(int freeweight)//0:δ���� >1:����
	{
		if(freeweight==23)
		{
			if(weight>23 && weight<=28)
				return 1;
			if(weight>28 && weight<=32)
				return 2;
			else return 0;
		}
		else//(freeweight==32)
			return 0;
	}
}
