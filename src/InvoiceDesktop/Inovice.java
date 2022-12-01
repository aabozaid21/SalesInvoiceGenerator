package InvoiceDesktop;

import java.util.ArrayList;
public class Inovice {
    private static   String InHeader ;
    private static  String InLine ;

    public String getInHeader() {
        return InHeader;
    }

    public void setInHeader(String InHeader) {
        Inovice.InHeader = InHeader;
    }



    public String getInLine() {
        return InLine;
    }

    public void setInLine(String InLine) {
        Inovice.InLine = InLine;
    }


    ReadWrite RW = new ReadWrite();

    public static ArrayList<Inovice> invoices = new ArrayList<Inovice>();
    private  ArrayList<Item> invoiceItems;

    private  int invoiceNO;
    private String date;
    private String clientName;



    public Inovice(){

    }

    public Inovice(int invoiceNO, String date, String clientName) {
        this.invoiceNO = invoiceNO;
        this.date = date;
        this.clientName = clientName;
    }

    public  int getInvoiceNO() {
        return invoiceNO;
    }

    public String getDate() {
        return date;
    }

    public String getClientName() {
        return clientName;
    }
    public ArrayList<Item> getInvoiceItems() {
        return invoiceItems;
    }




    public void setInvoiceItems(ArrayList<Item> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public  void setInvoiceNO(int invoiceNO) {
        this.invoiceNO = invoiceNO;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }






    public double getItemsTotalPrice(){
        double price=0;
        if(invoiceItems.size()==0){
            return 0;
        }
        invoices =  RW.read(InHeader,InLine);

        for (Item invoiceItem : invoiceItems) {
            price+=(invoiceItem.calTotalItemPrice());
        }
        return price;
    }

    public ArrayList<Inovice> returnAllInvoices() {
        invoices =  RW.read(InHeader,InLine);

        return invoices;
    }

    private String getInvoiceData() {
        return this.invoiceNO + "," + this.date + "," + this.clientName ;

    }
    public void saveInvoiceToFile(ArrayList<Inovice>invoice) {
        invoices =invoice;
        RW.clearTheFile(InHeader);
        for (Inovice element : invoices) {
            RW.write(element.getInvoiceData(), InHeader);
        }
    }


    @Override
    public String toString() {
        return  "Invoice_Number"+"(" + invoiceNO +")"+ " Invoice_Date:" + date +  " Customer_Name:" + clientName + " Total_Price:" + getItemsTotalPrice() + "\n" ;
    }
}
