package ch.schu.example.helloworld;

import ch.schu.example.hello.IHbslDTicketWebService;
import ch.schu.example.hello.IHbslDTicketWebServiceService;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

/**
 * @author Jack
 * @date 2018/12/18.
 */
public class HelloWorldClient {
    public static void main(String[] argv) {
        IHbslDTicketWebService service = new IHbslDTicketWebServiceService().getIHbslDTicketWebServicePort();
        //invoke business method
        String dataXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<request>" +
                "<ip>10.21.89.29</ip>" +
                "<hyid>181008112457089772</hyid>" +
                "<ddbh>181109000016</ddbh>" +
                "</request>";
        org.apache.cxf.endpoint.Client client = ClientProxy.getClient(service);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        http.getClient().setProxyServer("127.0.0.1");
        http.getClient().setProxyServerPort(8888);
        String response = service.cancelOrder(dataXml, "sign-----");
        System.out.println(response);
    }
}
