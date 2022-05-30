package org.example.grpc.demo.grpc.autoGenerate.service;

import org.example.grpc.demo.grpc.autoGenerate.model.HelloRequest;
import org.example.grpc.demo.grpc.autoGenerate.model.HelloResponse;

public abstract class HelloServiceImplBase implements io.grpc.BindableService {

    private static final int METHODID_HELLO = 0;

    public void hello(org.example.grpc.demo.grpc.autoGenerate.model.HelloRequest request,
                      io.grpc.stub.StreamObserver<org.example.grpc.demo.grpc.autoGenerate.model.HelloResponse> responseObserver) {
         io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(HelloServiceGrpc.getHelloMethod(), responseObserver);
    }

    public final io.grpc.ServerServiceDefinition bindService() {
        return io.grpc.ServerServiceDefinition.builder(HelloServiceGrpc.getServiceDescriptor())
                .addMethod(
                        HelloServiceGrpc.getHelloMethod(),
                        io.grpc.stub.ServerCalls.asyncUnaryCall(
                                new HelloServiceGrpc.MethodHandlers<
                                        HelloRequest,
                                        HelloResponse>(
                                        this, METHODID_HELLO)))
                .build();
    }
}
