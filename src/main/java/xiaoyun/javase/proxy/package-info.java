/**
 * Created by xiaoyunxiao on 15-4-3.
 * Java动态代理，代码来源:<Hadoop 技术内幕 深入解析Hadoop Common和HDFS架构设计与实现原理>
 * 机械工业出版社，蔡斌，2013.06
 *
 * 代理类在程序运行过程中创建，一旦被创建，就变成了常规类。
 * 一个代理类只有一个实例域--调用处理器:
 * <code>protected Proxy(InvocationHandler h)</code>
 *
 * 为了履行代理对象的职责，所需要的任何附加数据都必须存储在调用处理器中。如本包中代理接口实现类
 * <code>DPQueryStatusImpl</code>对象被调用处理器管理，实际通过接口调用方法时，在调用处理器
 * 的invoke方法中通过实际代理对象完成具体方法调用，可在调用前和调用后进行所需操作。如实现方法调用的跟踪。
 * (感觉像一个动态Wrapper)
 *
 * 而在Hadoop的RPC中,将远端服务器的地址，代理的接口信息保存在调用处理器Invoker中，通过代理调用接口的方法
 * 时，在Invoker对象中的invoke方法中，通过得知的服务器地址将调用的接口，方法名和参数等信息发送到指定服务器。
 * 在服务器端，由具体实现接口的实例完成调用操作并将响应发送回客户端。
 * 看服务器构造:
 * public Server(Object instance, Configuration conf, String bindAddress,int port,int numHandlers,
 * boolean verbose,SecretManager<? extends TokenIdentifier> secretManager)
 * 构造服务器需绑定实现指定接口的实例instance。
 *
 * 客户端代理的获取:
 * public static VersionedProtocol getProxy(Class<? extends VersionedProtocol> protocol,
 * long clientVersion, InetSocketAddress addr, UserGroupInformation ticket, Configuration conf,
 * SocketFactory factory, int rpcTimeout, RetryPolicy connectionRetryPolicy, boolean checkVersion)
 * 最主要的是protocol，addr以及ticket即用户信息，对应一个connectionId，创建Invoker对象，在具体调用invoke中
 * 定位服务器。而方法名和参数由动态代理机制在invoke方法参数中传入，发送到服务器端。
 */
package xiaoyun.javase.proxy;