package service.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.server.TServer.Args;
import service.demo.Hello;
import service.demo.HelloServiceImpl;

public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(7911);
            // 设置协议工厂为 TBinaryProtocol.Factory
            Factory myproFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TProcessor myprocessor = new Hello.Processor(new HelloServiceImpl());
            Args myargs = new Args(serverTransport);
            myargs.processor(myprocessor);
            myargs.protocolFactory(myproFactory);
            TServer server = new TSimpleServer(myargs);
            System.out.println("Start server on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}