
package droca;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Knn {
    int knn;

    public void test(int foundDid,boolean graphFlag) throws IOException
    {
    Connection con ;
    ResultSet rs ;
    int i,k=0,i1,j;
    int algo[]=new int[NewJFrame.classifierCnt];
    for(i=0;i<NewJFrame.classifierCnt;i++)
        algo[i]=i;
    int index[]=new int[NewJFrame.classifierCnt];
    ResultSet rs10 = null;
    int [][]rank=new int[60][20];
    double[] avg= new double[50];
    double sum,E_sum,temp1,temp2,t1,t2;
    Double d[]=new Double[NewJFrame.noOfChar];
    String a=null;
    if(graphFlag==false)
    while (a==null)
    {
        a=JOptionPane.showInputDialog("Enter the the number of similar available datasets that should be used for recommendation : ");
        try{
        knn=Integer.parseInt(a); //convert to int
        NewJFrame.knn_backup=knn;
        if(knn<1)
        {
            JOptionPane.showMessageDialog(null, "Please enter an Integer value greater than ZERO", "Invalid Value", JOptionPane.ERROR_MESSAGE);
            a=null;
        }
        if(knn>NewJFrame.noOfDset)
        {
            JOptionPane.showMessageDialog(null, "Insufficient Knowledge Base.\nPlease enter a smaller value.", "Invalid Value", JOptionPane.ERROR_MESSAGE);
            a=null;
        }
        }catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter an Integer value", "Invalid Value", JOptionPane.ERROR_MESSAGE);
            a=null;
        }
    }
    else knn=NewJFrame.knn_backup;
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
        Statement st1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=st1.executeQuery("select * from norm_tab");
        rs.absolute(foundDid);
        for(i=0;i<NewJFrame.noOfChar;i++)
           d[i]=Double.parseDouble(rs.getString(i+2));
        rs.last();
        NewJFrame.noOfDset=rs.getInt(1);
        double distances[]=new double[NewJFrame.noOfDset+1];
        int pr[]=new int[NewJFrame.noOfDset+1];
        rs.beforeFirst();//k=0;
        while(rs.next())
        { 	
            sum=0;	
            if(rs.getInt(1)!=foundDid)
            {
                for(int l=0;l<NewJFrame.noOfChar;l++)
                    sum=sum + Math.pow(rs.getFloat(l+2)-d[l],2);
                E_sum= Math.sqrt(sum);
                distances[k++]=E_sum;
            }
        }

        for(i=0;i<NewJFrame.noOfDset-1;i++)
            pr[i]=i+1;
 
        for(i1 = 0; i1 < NewJFrame.noOfDset-1; i1++)
        {
            for(j = 0; j < (NewJFrame.noOfDset-2); j++)
            {
                if(distances[j] > distances[j+1])
                {
                    temp1 = distances[j];
                    distances[j]=distances[j+1];
                    distances[j+1]=temp1;

                    temp2 = pr[j];
                    pr[j]=pr[j+1];
                    pr[j+1]=(int) temp2;

                }
            }
        }

        if(knn>1)
        {
            for(i=0; i<knn; i++)
            {
                if(NewJFrame.accRBtn.isSelected())
                rs10=st1.executeQuery("select * from sorted_best_acc where Did="+(pr[i])+"");
            //acc n time
                else if(NewJFrame.acctimeRBtn.isSelected())
                {
                    if(NewJFrame.fold==10)
                    {
                        if(NewJFrame.accd==0.1f)
                        rs10=st1.executeQuery("select * from sorted_best_accd1 where Did="+(pr[i])+"");
           
                        else if(NewJFrame.accd==1)
                        rs10=st1.executeQuery("select * from sorted_best_accd2 where Did="+(pr[i])+"");

                        else if(NewJFrame.accd==10)
                        rs10=st1.executeQuery("select * from sorted_best_accd3 where Did="+(pr[i])+""); 
                    }
                else if(NewJFrame.fold==5)
                rs10=st1.executeQuery("select * from sorted_best5 where Did="+(pr[i])+"");
                }
            //precision
                else if(NewJFrame.precRBtn.isSelected())
                rs10=st1.executeQuery("select * from sorted_bestp where Did="+(pr[i])+"");
            
            //recall
                else if(NewJFrame.recRBtn.isSelected())
                rs10=st1.executeQuery("select * from sorted_bestr where Did="+(pr[i])+"");

            //time
                else if(NewJFrame.timeRBtn.isSelected())
                rs10=st1.executeQuery("select * from sorted_best_time where Did="+(pr[i])+"");
            
             //recall + precision + acc
                else if(NewJFrame.precrecaccRBtn.isSelected())
                rs10=st1.executeQuery("select * from sorted_bestpra where Did="+(pr[i])+"");
            
                else{System.err.println("err");
                break;
            }

            rs10.next();

            for(k=0;k<NewJFrame.classifierCnt;k++) 
            {
                j=2;
                while( true && j<=(NewJFrame.classifierCnt+1))
                {
                    if(algo[k]==rs10.getInt(j))
                        break;
                    j++;
                    if(j==(NewJFrame.classifierCnt+2))
                        break;
                }
                rank[i][k]=j-1;
            }
        }

        for(j=0;j<NewJFrame.classifierCnt;j++)
        {
            avg[j]=0;
            for(i=0;i<knn;i++)
                //avg[j]=avg[j]+rank[i][j];
                avg[j]=avg[j]+((knn-i)*rank[i][j]);
            avg[j]=avg[j]/knn;
        }
 
        for(i=0;i<NewJFrame.classifierCnt;i++)
            index[i]=i;

        for(i=0; i<NewJFrame.classifierCnt; i++)
        {
            for(j=0; j<NewJFrame.classifierCnt-1; j++)
            {
                if(avg[j] >= avg[j+1])
                {
                    t1 = avg[j];
                    avg[j]=avg[j+1];
                    avg[j+1]=t1;

                    t2 = index[j];
                    index[j]=index[j+1];
                    index[j+1]=(int) t2;

                }
            }
        }
        }
        else if(knn==1)
        {
           if(NewJFrame.accRBtn.isSelected())
               rs10=st1.executeQuery("select * from sorted_best_acc where Did="+(pr[0])+"");
           else if(NewJFrame.acctimeRBtn.isSelected())
           {
                if(NewJFrame.fold==10)
                {
                    if(NewJFrame.accd==0.1f)
                    rs10=st1.executeQuery("select * from sorted_best_accd1 where Did="+(pr[0])+"");
                    
                    else if(NewJFrame.accd==1)
                    rs10=st1.executeQuery("select * from sorted_best_accd2 where Did="+(pr[0])+"");
               
                    else if(NewJFrame.accd==10)
                    rs10=st1.executeQuery("select * from sorted_best_accd3 where Did="+(pr[0])+"");
                }
                else if(NewJFrame.fold==5)
                    rs10=st1.executeQuery("select * from sorted_best5 where Did="+(pr[0])+"");
            } 
          //precision
           else if(NewJFrame.precRBtn.isSelected())
               rs10=st1.executeQuery("select * from sorted_bestp where Did="+(pr[0])+"");
            //recall
           else if(NewJFrame.recRBtn.isSelected())
               rs10=st1.executeQuery("select * from sorted_bestr where Did="+(pr[0])+"");
         
            //recall + precision + acc
           else if(NewJFrame.precrecaccRBtn.isSelected())
             rs10=st1.executeQuery("select * from sorted_bestpra where Did="+(pr[0])+"");
            
             //time
           else if(NewJFrame.timeRBtn.isSelected())
              rs10=st1.executeQuery("select * from sorted_best_time where Did="+(pr[0])+"");
            
            else{System.err.println("err");
            System.exit(0);
          } 
          
          j=2;
          t1=i;
          rs10.next();

          for(i=0;i<NewJFrame.classifierCnt;i++)
           {
               index[i]=Integer.parseInt(rs10.getString(j));
               j++;
           }  
        }
        else 
        {
            System.err.println("err");
            System.exit(0);
        }
        cnt=0;
       Connection con1 = DriverManager.getConnection(DROCA.url, DROCA.user, DROCA.password);
       Statement st2 = con1.createStatement();
        ResultSet rs2 = st2.executeQuery("select * from classifier;");
       
        for(i=0;i<NewJFrame.classifierCnt;i++)
        {
            rs2.beforeFirst();
            while(rs2.next())
            {
                if(rs2.getInt(1)==(algo[index[i]]+1))
                {

                    if(NewJFrame.fold==10)
                    {
                    ranking[cnt][0]=cnt+1;
                    graph_val[cnt]=rs2.getInt(1)-1;
                    ranking[cnt++][1]=rs2.getString(2);
                    }
                    else if(NewJFrame.fold==5)
                        graph_val5[cnt++]=rs2.getInt(1)-1;
                    break;
                }
            }
        }  
        con.close();

        }
    catch (ArrayIndexOutOfBoundsException|SQLException | ClassNotFoundException ex) {
              Logger lgr = Logger.getLogger(Knn.class.getName());
              lgr.addHandler(new FileHandler("%t/droca.log"));
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
    }
static Object[][] ranking =new Object[20][3];
static int cnt;
static int graph_val[]=new int[NewJFrame.classifierCnt];
static int graph_val5[]=new int[NewJFrame.classifierCnt];
}

