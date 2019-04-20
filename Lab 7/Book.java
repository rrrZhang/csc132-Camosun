/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

/**Mingrui Qin
 *COMP-132
 * @author q2301
 *Feb.20.2016

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Book {

	private String author;
	private String title;
	private String num;
	private double price;
	private int pages;
	int booknum = 2 ;
        
        
        public Book(){}
	
	public Book(String auther, String title, String num, double price){
		this.author = auther;
		this.title = title;
		this.num = num;
		this.price = price;
	        
        }
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getprice() {
		return (int) price;
	}

	public void setprice(double price) {
		this.price = price;
	}
        public void printBook(){
	    System.out.println("Total Number of books: "+ booknum);	
            System.out.println("author:" + author + ", title:" + title + ", pages:" + num + ", price:"+ price);
	}
        public void setTitle(String title) {
		this.title = title;
	}
public static void main(String[] args) {
	Book b = new Book("Nixon","Learning Php, MySQL and JavaScript","1024", 52.23);
        b.printBook();
	        
        Book a = new Book();
        a.settitle("The Shining");
        a.setauthor("George");
        a.setpages(256);
        a.setprice(256.25);
        a.printinfo();
     
}
  public String gettitle() {
        return title;
    }
 public String getauthor() {
        return author;
    
  }
 public void setauthor(String bookauthor) {
        author = bookauthor;
          }
  public void settitle(String booktitle) {
        title = booktitle;
          }



public int getpages() {
return pages;

}
public void setpages(int bookpages) {
    pages = bookpages;

}
public double price() {
return price;
}


public void printinfo(){

System.out.println("author:" + author +  " title: " + title + ", pages:" + pages + ", privce:"+ price);
	
  }

public void setbooknum(int booknumber) {
       booknum = booknumber;
       
}

public int booknum() {
        return booknum ;
   }

}




