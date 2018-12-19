package ch.schu.example.helloworld;

import ch.schu.example.hello.IHbslDTicketWebService;
import ch.schu.example.hello.IHbslDTicketWebServiceService;

import java.net.ProxySelector;

public class Client {

    public static void main(String[] args) {
        
        ProxySelector.setDefault(new MyProxySelector());

        IHbslDTicketWebServiceService serviceService = new IHbslDTicketWebServiceService();
        IHbslDTicketWebService service = serviceService.getIHbslDTicketWebServicePort();
        String dataXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<request>" +
                "<ip>10.21.89.29</ip>" +
                "<hyid>181008112457089772</hyid>" +
                "<ddbh>181109000016</ddbh>" +
                "</request>";
        String response = service.cancelOrder(dataXml,"");
        System.out.println(response);
    }
    
}
