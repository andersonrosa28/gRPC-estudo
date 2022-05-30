package org.example.grpc.demo.grpc.impl;

import io.grpc.stub.StreamObserver;
import org.example.grpc.demo.grpc.autoGenerate.model.HelloRequest;
import org.example.grpc.demo.grpc.autoGenerate.model.HelloResponse;
import org.example.grpc.demo.grpc.autoGenerate.service.HelloServiceImplBase;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Chamou o hello (HelloServiceImpl)");
        if(request != null) {
            System.out.println(request.getFirstName() + " " + request.getLastName());
        }


        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();
        System.out.println("Montou o greeting para retorno (HelloServiceImpl)");

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        System.out.println("Enviou a resposta (HelloServiceImpl)");

        responseObserver.onCompleted();
        System.out.println("Finalizou (HelloServiceImpl)");
    }

}
