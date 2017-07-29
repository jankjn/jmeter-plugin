## 简单jmeter thrift 调用 sampler 示例

### preconditions
1. mac platform, installed jmeter & gradle with homebrew
2. put libthrift.jar into lib of jmeter
### usage
1. gradle install at project root (will build the sampler jar and copy to lib/ext of jmeter)
2. start thrft server(HelloServiceServer)
3. jmeter [-t hello-load-test.jmx]
4. edit config & run
5. watch output of jmeter and server console
