package deletefile;
import java.io.*;
import java.util.*;
/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Flow {
    public Flow() {
    }

    @SuppressWarnings("unchecked")
	public void run(){
        try{
            //*********************读取正例所在的家族**********************
            BufferedReader br = new BufferedReader(new FileReader("un_pfamID.txt"));
            @SuppressWarnings("rawtypes")
			Vector posfam = new Vector();
            while(br.ready()){
                String line = br.readLine().trim();
                posfam.add(line);
            }
            br.close();


            //*************在反例文件夹中删除相应的文件*******************
            File f = new File("PF_all");
            File[] neg = f.listFiles();

            for(int i=0;i<neg.length;i++){
                boolean flag = false;
                for(int j=0;j<posfam.size();j++){
                    if(posfam.get(j).toString().equals(neg[i].getName().substring(0,neg[i].getName().indexOf('.')))){
                        flag = true;
                        break;
                    }
                }

                if(flag){

                    System.out.println(neg[i].getName());
                    neg[i].delete();
                    System.out.println(neg[i].getName());
                }
            }


        }
        catch(Exception ex){
            System.out.println(ex.getCause());
            System.exit(0);
        }
    }
}
