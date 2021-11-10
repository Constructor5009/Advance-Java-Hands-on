
package EJB;

import javax.ejb.Stateless;

@Stateless
public class CurrencyBean {

    public double convert(String from,String to,double damt)
    {
            double result=0;
     if(from.equals(to))
    {
     {return damt;}
    }
    else
    {
        if(to.equals("INR"))
        {
            result=damt*71.32;
            
        }
        else
        {
            result=damt/71.32;
        }
        return result;
    }
    }
}
