import java.util.ArrayList;

import java.util.ArrayList;
import InvoiceGui.InvoiceFrame;
import InvoiceDesktop.Inovice;
import InvoiceDesktop.Item;
import InvoiceDesktop.ReadWrite;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String Header = System.getProperty("user.dir") + "\\src\\csv\\InvoiceHeader.csv";
        String Line = System.getProperty("user.dir") + "\\src\\csv\\InvoiceLine.csv";
        /// String invoice;

        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Inovice> Invoices = new ArrayList<Inovice>();

        Inovice in = new Inovice();
        in.setInvoiceItems(items);
        in.setInHeader(Header);
        in.setInLine(Line);

        Invoices = in.returnAllInvoices();
        for (Inovice i : Invoices) {

            System.out.println(i.toString());

            items = i.getInvoiceItems();
            for (Item item : items) {
                System.out.println(/* "item name  " + */ item);

            }
            System.out.println("***************************************" + "****************************************"
                    + "*************************************");
        }

        InvoiceFrame JF = new InvoiceFrame();
        JF.LaunchJFrame();

    }
}