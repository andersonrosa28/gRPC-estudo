package org.example.grpc.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.demo.grpc.autoGenerate.model.HelloRequest;
import org.example.grpc.demo.grpc.autoGenerate.model.HelloResponse;
import org.example.grpc.demo.grpc.autoGenerate.service.HelloServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicializa o client (GrpcClient)");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        System.out.println("monta o stub (GrpcClient)");
        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        System.out.println("monta o request o stub (GrpcClient)");
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Anderson rosa")
                .setLastName("cascalho")
                .build());

        System.out.println("retorno do server (GrpcClient)");
        System.out.println(helloResponse.getGreeting());

        Thread.sleep(3000);
        System.out.println("fecha o client (GrpcClient)");
        channel.shutdown();
    }
}
