package com.knoldus.couchbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;

import java.util.List;

@Configuration
public class CouchBaseConfiguration extends AbstractReactiveCouchbaseConfiguration {

    private final String bucketUsername;
    private CouchbaseProperties couchbaseProperties;

    public CouchBaseConfiguration(CouchbaseProperties couchbaseProperties,
                                  @Value("${spring.couchbase.bucket.username}") String bucketUsername) {
        this.couchbaseProperties = couchbaseProperties;
        this.bucketUsername = bucketUsername;
    }

    @Override
    protected List<String> getBootstrapHosts() {
        return couchbaseProperties.getBootstrapHosts();
    }

    @Override
    protected String getBucketName() {
        return couchbaseProperties.getBucket().getName();
    }

    @Override
    protected String getBucketPassword() {
        return couchbaseProperties.getBucket().getPassword();
    }

    @Override
    protected String getUsername() {
        return bucketUsername;
    }
}
