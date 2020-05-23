import java.util.ArrayList;

public class Cacu {
    int type=0;
    String ty="";
    boolean warning1;
    protected float checkticket(int line, int passager, int seat, String prices,
                                ArrayList<SpeLuggage> speluglist, ArrayList<Luggage> luglist)
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
}
