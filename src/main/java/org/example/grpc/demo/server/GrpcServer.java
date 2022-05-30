package org.example.grpc.demo.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.grpc.demo.grpc.impl.HelloServiceImpl;

public class GrpcServer {
    public static void main(String[] args) {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        try {
            System.out.println("Inicializa o server (GrpcServer)");
            server.start();
            server.awaitTermination();
            System.out.println("Finaliza o server (GrpcServer)");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
