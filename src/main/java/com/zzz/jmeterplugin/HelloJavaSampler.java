package com.zzz.jmeterplugin;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.thrift.TException;
import service.client.HelloServiceClient;

public class HelloJavaSampler extends AbstractJavaSamplerClient {

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        final SampleResult result = new SampleResult();
        result.sampleStart();

        try {
            final String reply = HelloServiceClient.greet("hello");

            result.sampleEnd();
            result.setSuccessful(true);
            result.setResponseMessage(reply);
            result.setResponseCodeOK();
        } catch (TException e) {
            result.sampleEnd();
            result.setSuccessful(false);
            result.setResponseMessage("Exception: " + e);
        }
        return result;
    }
}