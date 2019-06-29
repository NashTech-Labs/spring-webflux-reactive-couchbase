package com.knoldus.couchbase.model;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

@Getter
@Setter
@Document
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(delimiter = "::", strategy = USE_ATTRIBUTES)
    String id;

    @Field
    @IdAttribute
    String userId;

    @Field
    String firstName;

    @Field
    String lastName;

    @Field
    String city;

    @Field
    String phone;

}
