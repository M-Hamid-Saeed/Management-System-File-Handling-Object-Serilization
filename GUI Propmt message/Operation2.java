
	/*public static void main(String[] args){
		books book1= new books();
		book1.name= "Java PRogramming";
		book1.quantity= 12;
	System.out.println(book1.name + " "+book1.quantity);
	dosomething(book1);
	
	}
	public static void dosomething(books b){
		b.name="Hamidf";
		b.quantity=123;
	System.out.println(b.name + " "+b.quantity);}
*/
class Operation2{  
	int data=50;  
	 
	void change(Operation2 op){  
	this.data=op.data+100;//changes will be in the instance variable  
	}  
		
	   
	public static void main(String args[]){  
	  Operation2 op=new Operation2();  
	 
	  System.out.println("before change "+op.data);  
	  op.change(op);//passing object  
	  System.out.println("after change "+op.data);  
	 
	}  
   }  