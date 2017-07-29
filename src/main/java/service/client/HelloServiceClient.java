package service.client;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import service.demo.Hello;

public class HelloServiceClient {

    /**
     * 调用 Hello 服务
     */
    public static void main(String[] args) throws TException {
        greet("hello");
    }

    public static String kao() { return "kao!"; }

    public static String greet(String message) throws TException {
        // 设置调用的服务地址为本地，端口为 7911
        TTransport transport = new TSocket("localhost", 7911);
        try {
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            // 调用服务的 helloVoid 方法
            return client.helloString(message);
        } finally {
            transport.close();
        }
    }
}