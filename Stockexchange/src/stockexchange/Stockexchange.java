/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockexchange;
import static java.lang.Math.*;
import java.util.*;
/**
 *
 * @author ale
 */
public class Stockexchange {

    /**
     * @param args the command line arguments
     */
    ArrayList<Double> last_dividend = new ArrayList<>();
    ArrayList<Double> per_value = new ArrayList<>();
    ArrayList<Double> fixed_dividend = new ArrayList<>();
    ArrayList<String> stock_symbol = new ArrayList<>();
    ArrayList<Integer> price = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    
    /*
     * this method calculate the Dividend yield
     */
    public void dividend_yield()
    {
        double temp_dividend;
        for( int i = 0; i <= 4;i++ )
        {
                System.out.println("Stock symbol :"+stock_symbol.get(i));
                for ( int j = 0; j < price.size(); j++  )
                {
                    temp_dividend = last_dividend.get(i)/price.get(j);
                    temp_dividend =  Math.round(temp_dividend * 100d) / 100d;
                    if ( temp_dividend != 0.0 )
                    {
                        System.out.println("Dividend yield (common): for price"+(j+1)+": "+temp_dividend);
                    }else
                    {
                        System.out.println("Dividend yield (common): for price"+(j+1)+":  No Data");
                    }
                }
            if ( fixed_dividend.get(i) != 0 )
            {
                for ( int j = 0; j < price.size(); j++  )
                {
                    temp_dividend = ((last_dividend.get(i)*fixed_dividend.get(i))*per_value.get(i)/price.get(j));
                    temp_dividend =  Math.round(temp_dividend * 100d) / 100d;
                    if ( temp_dividend != 0.0 )
                    {
                        System.out.println("Dividend yield(Preferred): for price"+(j+1)+": "+temp_dividend);
                    }else
                    {
                        System.out.println("Dividend yield(Preferred): for price"+(j+1)+":  No Data");
                    }
                }
            }
            
        }
    }
    
    /*
     * this method is used to calculate the P/E ratio
     */
    public void p_e_ratio()
    {
        double temp_dividend;
        for( int i = 0; i <= 4;i++ )
        {
            System.out.println("Stock symbol :"+stock_symbol.get(i));
            for ( int j = 0; j < price.size(); j++  )
            {
                temp_dividend = last_dividend.get(i)/price.get(j) ;
                temp_dividend = price.get(j)/temp_dividend;
                temp_dividend =  Math.round(temp_dividend * 100d) / 100d;
                if ( last_dividend.get(i) != 0.0 )
                {
                    System.out.println("P/E Ratio for price"+(j+1)+": "+temp_dividend);
                }
                else
                {
                    System.out.println("P/E Ratio for price"+(j+1)+":  No Data");
                }
                            
            }
        }
    }
    
   /*
    *   this method is use to calculate the geometric mean
    */
    public void geometric_mean()
    {
        double geometric_mean = 1;
        for ( int i = 0; i < price.size(); i++  )
        {
            geometric_mean = geometric_mean*price.get(i);
        }
        double number = price.size();
        geometric_mean = pow(geometric_mean, 1/number);
        geometric_mean =  Math.round(geometric_mean * 100d) / 100d;
        System.out.println("Geometric mean is: "+geometric_mean);
    }
    
    /*
     *  this method calculate the volume weighted stock price
     */
    public void volume_weighted()
    {
        double e_price = 0;
        double e_quantity = 0;
        double temp = 0;
        
        for ( int i = 0; i < quantity.size(); i++)
        {
            e_quantity = e_quantity + quantity.get(i);
        }
        for ( int w = 0; w < price.size(); w++)
        {
            e_price = e_price+price.get(w);
        }
        
        for ( int i = 0; i < quantity.size(); i++)
        {
            temp = (e_price*quantity.get(i))/e_quantity;
            temp =  Math.round(temp * 100d) / 100d;
            System.out.println("The Volume Weighted stock price for Q"+(i+1)+": "+ temp );
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stockexchange st = new Stockexchange();
        st.last_dividend.add(0.0);
        st.last_dividend.add(8.0);
        st.last_dividend.add(23.0);
        st.last_dividend.add(8.0);
        st.last_dividend.add(13.0);
        
        st.per_value.add(100.0);
        st.per_value.add(100.0);
        st.per_value.add(60.0);
        st.per_value.add(100.0);
        st.per_value.add(250.0);
        
        st.fixed_dividend.add(0.0);
        st.fixed_dividend.add(0.0);
        st.fixed_dividend.add(0.0);
        st.fixed_dividend.add(2.0);
        st.fixed_dividend.add(0.0);
        
        st.stock_symbol.add("TEA");
        st.stock_symbol.add("POP");
        st.stock_symbol.add("ALE");
        st.stock_symbol.add("GIN");
        st.stock_symbol.add("JOE");
        
        
        int choice,count=0;
        int price_1,quantity_1;
        
        do{
            while( count < 2 )
            {
               System.out.println("Enter the price");
               price_1 = sc.nextInt();
               st.price.add(price_1);
               System.out.println("Enter the quantity");
               quantity_1 = sc.nextInt();
               st.quantity.add(quantity_1);
               count++; 
            }
            System.out.println("Press '1' to enter more prices");
            System.out.println("Press '0' to generate the calculations");
            choice = sc.nextInt();
            count = 1;
        }while( choice == 1 );
        
        st.dividend_yield();
        st.p_e_ratio();
        st.geometric_mean();
        st.volume_weighted();
        
    }
}
