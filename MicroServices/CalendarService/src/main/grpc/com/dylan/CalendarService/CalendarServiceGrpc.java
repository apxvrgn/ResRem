package com.dylan.CalendarService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: Calendar.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CalendarServiceGrpc {

  private CalendarServiceGrpc() {}

  public static final String SERVICE_NAME = "CalendarService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dylan.CalendarService.Calendar.EventsRequest,
      com.dylan.CalendarService.Calendar.Events> getRetrieveEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveEvents",
      requestType = com.dylan.CalendarService.Calendar.EventsRequest.class,
      responseType = com.dylan.CalendarService.Calendar.Events.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dylan.CalendarService.Calendar.EventsRequest,
      com.dylan.CalendarService.Calendar.Events> getRetrieveEventsMethod() {
    io.grpc.MethodDescriptor<com.dylan.CalendarService.Calendar.EventsRequest, com.dylan.CalendarService.Calendar.Events> getRetrieveEventsMethod;
    if ((getRetrieveEventsMethod = CalendarServiceGrpc.getRetrieveEventsMethod) == null) {
      synchronized (CalendarServiceGrpc.class) {
        if ((getRetrieveEventsMethod = CalendarServiceGrpc.getRetrieveEventsMethod) == null) {
          CalendarServiceGrpc.getRetrieveEventsMethod = getRetrieveEventsMethod =
              io.grpc.MethodDescriptor.<com.dylan.CalendarService.Calendar.EventsRequest, com.dylan.CalendarService.Calendar.Events>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetrieveEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dylan.CalendarService.Calendar.EventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dylan.CalendarService.Calendar.Events.getDefaultInstance()))
              .setSchemaDescriptor(new CalendarServiceMethodDescriptorSupplier("RetrieveEvents"))
              .build();
        }
      }
    }
    return getRetrieveEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dylan.CalendarService.Calendar.MarkEventRequest,
      com.google.protobuf.Empty> getMarkEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkEvent",
      requestType = com.dylan.CalendarService.Calendar.MarkEventRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dylan.CalendarService.Calendar.MarkEventRequest,
      com.google.protobuf.Empty> getMarkEventMethod() {
    io.grpc.MethodDescriptor<com.dylan.CalendarService.Calendar.MarkEventRequest, com.google.protobuf.Empty> getMarkEventMethod;
    if ((getMarkEventMethod = CalendarServiceGrpc.getMarkEventMethod) == null) {
      synchronized (CalendarServiceGrpc.class) {
        if ((getMarkEventMethod = CalendarServiceGrpc.getMarkEventMethod) == null) {
          CalendarServiceGrpc.getMarkEventMethod = getMarkEventMethod =
              io.grpc.MethodDescriptor.<com.dylan.CalendarService.Calendar.MarkEventRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MarkEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dylan.CalendarService.Calendar.MarkEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CalendarServiceMethodDescriptorSupplier("MarkEvent"))
              .build();
        }
      }
    }
    return getMarkEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalendarServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalendarServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalendarServiceStub>() {
        @java.lang.Override
        public CalendarServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalendarServiceStub(channel, callOptions);
        }
      };
    return CalendarServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalendarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalendarServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalendarServiceBlockingStub>() {
        @java.lang.Override
        public CalendarServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalendarServiceBlockingStub(channel, callOptions);
        }
      };
    return CalendarServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalendarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CalendarServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CalendarServiceFutureStub>() {
        @java.lang.Override
        public CalendarServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CalendarServiceFutureStub(channel, callOptions);
        }
      };
    return CalendarServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CalendarServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void retrieveEvents(com.dylan.CalendarService.Calendar.EventsRequest request,
        io.grpc.stub.StreamObserver<com.dylan.CalendarService.Calendar.Events> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetrieveEventsMethod(), responseObserver);
    }

    /**
     */
    public void markEvent(com.dylan.CalendarService.Calendar.MarkEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarkEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRetrieveEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.dylan.CalendarService.Calendar.EventsRequest,
                com.dylan.CalendarService.Calendar.Events>(
                  this, METHODID_RETRIEVE_EVENTS)))
          .addMethod(
            getMarkEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.dylan.CalendarService.Calendar.MarkEventRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_MARK_EVENT)))
          .build();
    }
  }

  /**
   */
  public static final class CalendarServiceStub extends io.grpc.stub.AbstractAsyncStub<CalendarServiceStub> {
    private CalendarServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalendarServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalendarServiceStub(channel, callOptions);
    }

    /**
     */
    public void retrieveEvents(com.dylan.CalendarService.Calendar.EventsRequest request,
        io.grpc.stub.StreamObserver<com.dylan.CalendarService.Calendar.Events> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void markEvent(com.dylan.CalendarService.Calendar.MarkEventRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarkEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalendarServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CalendarServiceBlockingStub> {
    private CalendarServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalendarServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalendarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dylan.CalendarService.Calendar.Events retrieveEvents(com.dylan.CalendarService.Calendar.EventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveEventsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty markEvent(com.dylan.CalendarService.Calendar.MarkEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarkEventMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalendarServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CalendarServiceFutureStub> {
    private CalendarServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalendarServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CalendarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dylan.CalendarService.Calendar.Events> retrieveEvents(
        com.dylan.CalendarService.Calendar.EventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveEventsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> markEvent(
        com.dylan.CalendarService.Calendar.MarkEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarkEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE_EVENTS = 0;
  private static final int METHODID_MARK_EVENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalendarServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalendarServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RETRIEVE_EVENTS:
          serviceImpl.retrieveEvents((com.dylan.CalendarService.Calendar.EventsRequest) request,
              (io.grpc.stub.StreamObserver<com.dylan.CalendarService.Calendar.Events>) responseObserver);
          break;
        case METHODID_MARK_EVENT:
          serviceImpl.markEvent((com.dylan.CalendarService.Calendar.MarkEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalendarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalendarServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dylan.CalendarService.Calendar.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalendarService");
    }
  }

  private static final class CalendarServiceFileDescriptorSupplier
      extends CalendarServiceBaseDescriptorSupplier {
    CalendarServiceFileDescriptorSupplier() {}
  }

  private static final class CalendarServiceMethodDescriptorSupplier
      extends CalendarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalendarServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalendarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalendarServiceFileDescriptorSupplier())
              .addMethod(getRetrieveEventsMethod())
              .addMethod(getMarkEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
