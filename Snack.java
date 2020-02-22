import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*<applet code="Snack" width=500 height=500>
</applet>*/

public class Snack extends Applet implements Runnable,KeyListener
{
   Thread t;   
   int x1,y1,w,h,pointx=200,pointy=200;
   String msg,flag;
   int time=10;
  
   public void init()
    {
         t=new Thread(this);        
         flag="R";
         msg="R";
         w=50;
         h=5;
         addKeyListener(this);
         requestFocus();        
         t.start();       
    }

    public void keyPressed(KeyEvent ke)
    {
      showStatus("Key Down");
      int key=ke.getKeyCode();

      switch(key)
      {
        case KeyEvent.VK_RIGHT:
           msg="R";
           flag="R";
           break;
        case KeyEvent.VK_LEFT:
           msg="L";
           flag="L";
           //pos=getSize().width-35;
           break;

        case KeyEvent.VK_UP:
             msg="U";
             flag="U";
             break;

        case KeyEvent.VK_DOWN:
             msg="D";
             flag="D";
             break;

        case KeyEvent.VK_S:
            msg="stop";
            flag="S";
            break;
      }
      repaint();
    }

    public void keyReleased(KeyEvent ke)
    {
      showStatus("key up");
    }

    public void keyTyped(KeyEvent ke)
    {}

    public void run()
     {          
       try 
        {   
           if(flag=="R"||flag=="L"||flag=="U"||flag=="D")
            {
              while(true)
               {
                  repaint();
             	  Thread.sleep(time);  
                  if (flag=="R") 
                   {   
                   	// int temp1,temp2,temp3;
                    //     temp1=w;
                    //     w=h;
                    //     h=temp1;
                   	   
                     w=50;
                     h=5;
                  
                     while(x1!=getSize().width-40) 
             	      {  
             	    
             	        repaint();
             	        Thread.sleep(time); 
             	        x1+=1;   
             	        if (flag!="R")
             	     	  break;                                             
                      }
                     while(x1!=0)
                      {                      
             	     	repaint();
             	     	Thread.sleep(time);
             	     	x1-=1;
             	     	if (flag!="R")
             	         break;                       	
                      }                    
                   }

                  if (flag=="L")
                   {
                   	// int temp1,temp2,temp3;
                   	//  temp1=w;
                    //   w=h;
                    //   h=temp1;
                     w=50;
                     h=5;  
                     
                     while(x1!=0) 
             		  {          		     	
             		    repaint();
             		    Thread.sleep(time); 
             		    x1-=1;  
             		    if (flag!="L")
             		      break;             
                      }
                     while(x1!=getSize().width-40)
                      {                         	 
                         repaint();  
                         Thread.sleep(time);  
                         x1+=1;
                         if (flag!="L")
             		     break;                          
                      }                                          
                    }

                     if (flag=="U") 
                     {    

                         // int temp1,temp2,temp3;
                         // temp1=h;
                         // h=w;
                         // w=temp1;          
                         w=5;
                         h=50;  
                          
                         while(y1!=0) 
             		     {          		     	
             		        repaint();
             		        Thread.sleep(time); 
             		        y1-=1;  
             		        if (flag!="U")
             		     		break;             
                         }
                         while(y1!=getSize().height-20)
                         {                         	  
                         	repaint();  
                         	Thread.sleep(time);  
                         	y1+=1;  
                         	if (flag!="U")
             		         break;                       
                         }                      
                     }

                     if (flag=="D") 
                     {   
                     	// int temp1,temp2,temp3;
                      //    temp1=h;
                      //    h=w;
                      //    w=temp1;                     
                         w=5;
                         h=50;  

                          while(y1!=getSize().height-20) 
             		     {          		     	
             		        repaint();
             		        Thread.sleep(time); 
             		        y1+=1;  
             		        if (flag!="D")
             		     		break;             
                         }
                         while(y1!=0)
                         {                        	  
                         	 repaint();  
                         	 Thread.sleep(time);  
                         	 y1-=1;  
                         	 if (flag!="D")
             		     	   break;                       
                         }                       
                     }             		             		  
             	   }              	   
                 }        
             }    
             catch(Exception e)
               {
                  System.out.println(e.getMessage()); 
               }
           }

   public void paint(Graphics g)
    {        
          g.fillRect(1+x1,1+y1,w,h);
          g.drawString(msg,50,50);

           g.drawString("x1::"+x1,10,10);
           g.drawString("y1::"+y1,60,10);
           g.drawString("pointx::"+pointx,120,10);
           g.drawString("pointy::"+pointy,200,10); 
           g.drawString("height::"+getSize().height,300,10);
           g.drawString("width::"+getSize().width,400,10); 

            if (x1+50>=pointx && y1+10>=pointy)
            {         
            	pointx=(int)(Math.random()*getSize().width);
                pointy=(int)(Math.random()*getSize().height);
                w+=3;
            }   
           g.fillOval(pointx,pointy,10,10);          
    }
}    