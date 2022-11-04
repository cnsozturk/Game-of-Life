import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;

public class GameOfLife {
	
	public static void main(String[] args) throws InterruptedException {

	int M=0,N=0;
	final String IN_FILE = "input.txt";
	BufferedReader br = null;


// M and N are the size of of the game board given in the input file

	    try {
	    	br = new BufferedReader(new FileReader(IN_FILE));
	        int i=0;
	        String data;

	        while(( i<2) && (data = br.readLine() )!= null ) {
	      
	        		{
		         
		          if (i==0)
		          {
		          M=Integer.parseInt(data);
//		          System.out.println(M);
		          }
		          if (i==1)
		          {N=Integer.parseInt(data);
//		          System.out.println(N);
		          }
		          i++;
		        }}
	        Board board = new Board(M,N);
//	        board.print();
	        int[][] neigbours = new int[M][N];
	        for(int k=0; k<M; k++) {
		         
	        	for(int j=0; j<N; j++)
	        	{
			        neigbours[k][j]=0;
			  

	        	}

	        }
	        
// rest of the file is read to get initial coordinates from input file

	        while((data = br.readLine() )!= null && i>=2) {
		   
		        	
			          
			          int row=Integer.parseInt(data.substring(0,1));
			          int column=Integer.parseInt(data.substring(2));
			         
				
					board.cells[row][column] = '#';
			         
//					board.print();
			          

//			          System.out.println("row "+row);
//			          System.out.println("column "+column);
			          i++;
			    
			          
			        }
	        board.print();
	  
	        LocalTime now = LocalTime.now();
	      	int lastSecond = now.getSecond();
//	          board.clearConsole();

	        while (true) {
	        
	        
	        	
	        for(i=0; i<M; i++) {
		         
	        	for(int j=0; j<N; j++)
	        	{
			        if (board.cells[i][j]=='#')
			        {
			        if (i==0 && j==0) {
			        	neigbours[M-1][N-1]+=1;
			        	neigbours[M-1][j]+=1;
				        neigbours[M-1][j+1]+=1;

				        neigbours[i][N-1]+=1;
				        neigbours[i][j+1]+=1;

				        neigbours[i+1][N-1]+=1;
				        neigbours[i+1][j]+=1;
				        neigbours[i+1][j+1]+=1;
			        }
			        else if (i==0 && j<N-1 && j!=0) {
			        	neigbours[M-1][j-1]+=1;
				        neigbours[M-1][j]+=1;
				        neigbours[M-1][j+1]+=1;

				        neigbours[i][j-1]+=1;
				        neigbours[i][j+1]+=1;

				        neigbours[i+1][j-1]+=1;
				        neigbours[i+1][j]+=1;
				        neigbours[i+1][j+1]+=1;
			        }	
			        else if (i<M-1 && i!=0 && j==0) {
			        	 neigbours[i-1][N-1]+=1;
					        neigbours[i-1][j]+=1;
					        neigbours[i-1][j+1]+=1;

					        neigbours[i][N-1]+=1;
					        neigbours[i][j+1]+=1;

					        neigbours[i+1][N-1]+=1;
					        neigbours[i+1][j]+=1;
					        neigbours[i+1][j+1]+=1;
			        }	
			        	
			        else if (i==M-1 && j==N-1) {
			        	neigbours[i-1][j-1]+=1;
				        neigbours[i-1][j]+=1;
				        neigbours[i-1][0]+=1;

				        neigbours[i][j-1]+=1;
				        neigbours[i][0]+=1;

				        neigbours[0][j-1]+=1;
				        neigbours[0][j]+=1;
				        neigbours[0][0]+=1;
			        }	
			        else if (i==M-1 && j==0) {
			        	neigbours[i-1][N-1]+=1;
				        neigbours[i-1][j]+=1;
				        neigbours[i-1][j+1]+=1;

				        neigbours[i][N-1]+=1;
				        neigbours[i][j+1]+=1;

				        neigbours[0][N-1]+=1;
				        neigbours[0][j]+=1;
				        neigbours[0][j+1]+=1;
			        }
			        
			        else if (i==0 && j==N-1) {
			        	neigbours[M-1][j-1]+=1;
				        neigbours[M-1][j]+=1;
				        neigbours[M-1][0]+=1;

				        neigbours[i][j-1]+=1;
				        neigbours[i][0]+=1;

				        neigbours[i+1][j-1]+=1;
				        neigbours[i+1][j]+=1;
				        neigbours[i+1][0]+=1;
			        }
			        else if (i==M-1 && j<N-1 && j!=0) {
			        	neigbours[i-1][j-1]+=1;
				        neigbours[i-1][j]+=1;
				        neigbours[i-1][j+1]+=1;

				        neigbours[i][j-1]+=1;
				        neigbours[i][j+1]+=1;

				        neigbours[0][j-1]+=1;
				        neigbours[0][j]+=1;
				        neigbours[0][j+1]+=1;
			        }
			        else if (i!=0 && i<M-1 && j==N-1) {
			        	neigbours[i-1][j-1]+=1;
				        neigbours[i-1][j]+=1;
				        neigbours[i-1][0]+=1;

				        neigbours[i][j-1]+=1;
				        neigbours[i][0]+=1;

				        neigbours[i+1][j-1]+=1;
				        neigbours[i+1][j]+=1;
				        neigbours[i+1][0]+=1;
			        }
			        else
			        {neigbours[i-1][j-1]+=1;
			        neigbours[i-1][j]+=1;
			        neigbours[i-1][j+1]+=1;

			        neigbours[i][j-1]+=1;
			        neigbours[i][j+1]+=1;

			        neigbours[i+1][j-1]+=1;
			        neigbours[i+1][j]+=1;
			        neigbours[i+1][j+1]+=1;
			        
			    }
			     
			        
			        }
			        }


	        	}	       
//         	 System.out.println(Arrays.deepToString(neigbours));
	        for (int row = 0; row < neigbours.length; row++)//Cycles through rows
	        {
	          for (int col = 0; col < neigbours.length; col++)//Cycles through columns
	          {

			        int count=0;
	        	  if (board.cells[row][col]=='#'||board.cells[row][col]=='*'  ) {
	        		  if (row==0 && col ==0)
	        		  { if(board.cells[M-1][N-1]=='#'|| board.cells[M-1][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[M-1][col]=='#'|| board.cells[M-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[M-1][col+1]=='#'|| board.cells[M-1][col+1]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][N-1]=='#'|| board.cells[row][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][col+1]=='#'|| board.cells[row][col+1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][N-1]=='#'|| board.cells[row+1][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col]=='#'|| board.cells[row+1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col+1]=='#'|| board.cells[row+1][col+1]=='*')
	        	    		 count++;}  
	        		  else if (row==0 && col <N-1&& col!=0)
	        		  { if(board.cells[M-1][col-1]=='#'|| board.cells[M-1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[M-1][col]=='#'|| board.cells[M-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[M-1][col+1]=='#'|| board.cells[M-1][col+1]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][col-1]=='#'|| board.cells[row][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][col+1]=='#'|| board.cells[row][col+1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col-1]=='#'|| board.cells[row+1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col]=='#'|| board.cells[row+1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col+1]=='#'|| board.cells[row+1][col+1]=='*')
	        	    		 count++;}  
	        		  else if (row<M-1 && row!=0 && col==0)
	        		  {  if(board.cells[row-1][N-1]=='#'||board.cells[row-1][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col]=='#'||board.cells[row-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col+1]=='#'||board.cells[row-1][col+1]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][N-1]=='#'||board.cells[row][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][col+1]=='#'||board.cells[row][col+1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][N-1]=='#'||board.cells[row+1][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col]=='#'||board.cells[row+1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col+1]=='#'||board.cells[row+1][col+1]=='*')
	        	    		 count++;}
	        		  else if (row==M-1 && col==N-1)
	        		  {  if(board.cells[row-1][col-1]=='#'||board.cells[row-1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col]=='#'||board.cells[row-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][0]=='#'||board.cells[row-1][0]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][col-1]=='#'||board.cells[row][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][0]=='#'||board.cells[row][0]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col-1]=='#'||board.cells[0][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col]=='#'||board.cells[0][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][0]=='#'||board.cells[0][0]=='*')
	        	    		 count++;} 
	        		  else if (row==M-1 && col<N-1 && col!=0)
	        		  {  if(board.cells[row-1][col-1]=='#'||board.cells[row-1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col]=='#'||board.cells[row-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col+1]=='#'||board.cells[row-1][col+1]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][col-1]=='#'||board.cells[row][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][col+1]=='#'||board.cells[row][col+1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col-1]=='#'||board.cells[0][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col]=='#'||board.cells[0][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col+1]=='#'||board.cells[0][col+1]=='*')
	        	    		 count++;} 
	        		  else if (row<M-1 && row!=0&& col==N-1 )
	        		  {  if(board.cells[row-1][col-1]=='#'||board.cells[row-1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col]=='#'||board.cells[row-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][0]=='#'||board.cells[row-1][0]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][col-1]=='#'||board.cells[row][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][0]=='#'||board.cells[row][0]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col-1]=='#'||board.cells[row+1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col]=='#'||board.cells[row+1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][0]=='#'||board.cells[row+1][0]=='*')
	        	    		 count++;}  
	        		  else if (row==M-1 && col==0 )
	        		  {  if(board.cells[row-1][N-1]=='#'||board.cells[row-1][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col]=='#'||board.cells[row-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col+1]=='#'||board.cells[row-1][col+1]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][N-1]=='#'||board.cells[row][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][col+1]=='#'||board.cells[row][col+1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][N-1]=='#'||board.cells[0][N-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col]=='#'||board.cells[0][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[0][col+1]=='#'||board.cells[0][col+1]=='*')
	        	    		 count++;}  
	        		  else if (row==0 && col==N-1 )
	        		  {  if(board.cells[M-1][col-1]=='#'||board.cells[M-1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[M-1][col]=='#'||board.cells[M-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[M-1][0]=='#'||board.cells[M-1][0]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][col-1]=='#'||board.cells[row][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][0]=='#'||board.cells[row][0]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col-1]=='#'||board.cells[row+1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col]=='#'||board.cells[row+1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][0]=='#'||board.cells[row+1][0]=='*')
	        	    		 count++;}  
	        			      
	        			  
	        		  else
	        		  {
	        	    	 if(board.cells[row-1][col-1]=='#'||board.cells[row-1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col]=='#'|| board.cells[row-1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row-1][col+1]=='#'||board.cells[row-1][col+1]=='*')
	        	    		 count++;
	        	  
	        	    	 if(board.cells[row][col-1]=='#'||board.cells[row][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row][col+1]=='#'|| board.cells[row][col+1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col-1]=='#'|| board.cells[row+1][col-1]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col]=='#'|| board.cells[row+1][col]=='*')
	        	    		 count++;
	        	    	 if(board.cells[row+1][col+1]=='#'|| board.cells[row+1][col+1]=='*')
	        	    		 count++;}
	        		  if (count==2 || count ==3)
	        		  board.cells[row][col]='#';
	        		  if (count<2 || count >3)
	        		 board.cells[row][col]='*';

//	     		          System.out.println("row col"+row+col+count);
	     		          }  }}
//	        	  if (board.cells[row][col]=='#' &&  neigbours[row][col]==2 || neigbours[row][col]==3 	 ) {
//	        	    	 board.cells[row][col]='#';
//
//	     		          }
	  // Any dead cell with three live neighbours becomes a live cell in the next generation;     	  
		       
	        for (int row = 0; row < neigbours.length; row++)//Cycles through rows
	        {
	          for (int col = 0; col < neigbours.length; col++)//Cycles through columns
	          {
	        	  
	           
	        if (board.cells[row][col]==' ' &&  neigbours[row][col]==3	 ) {
       	    	 board.cells[row][col]='#';

    		          }
	        if (board.cells[row][col]=='*' ) {
   	    	 board.cells[row][col]=' ';

		          }
//       	     else  board.cells[row][col]=' ';

		          

	          }}
	       // wait for 1 second
	        Thread.sleep(1000);
	          System.out.println(); //Makes a new row


	      
// prints the board.cells   	
	       

	      	LocalTime later=LocalTime.now();
	    	int s=later.getSecond();
	          if(s!=lastSecond) {
        	 for (i = 0; i<neigbours.length;i++) {
        		    for (int j = 0; j<neigbours.length; j++) {
        		        System.out.print(board.cells[i][j]);

        		    }
        		    System.out.println();
        		}}
//        	 prints the neigbours.cells  	        
//        	 for (i = 0; i<neigbours.length;i++) {
//     		    for (int j = 0; j<neigbours.length; j++) {
//     		        System.out.print(neigbours[i][j]);
//     		        
//     		    }
//     		    System.out.println();
//     		}
//	        begin with 0 neigbours each time
        	 for (i = 0; i<neigbours.length;i++) {
      		    for (int j = 0; j<neigbours.length; j++) {
      		        neigbours[i][j]=0;
      		        
      		    }
      		}
			br.close();
			
			
	        
	        }	} catch (IOException e) {
				e.printStackTrace();
			}
	    
}}
	
