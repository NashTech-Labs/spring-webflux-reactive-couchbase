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
public class ClubMemberProfile {

    @Id
    @GeneratedValue(delimiter = "::", strategy = USE_ATTRIBUTES)
    String id;

    @Field
    @IdAttribute(order = 0)
    String userId;

    @Field
    @IdAttribute(order = 1)
    String clubCode;

    @Field
    @IdAttribute(order = 2)
    String joiningDate;

    @Field
    String location;

    @Field
    String brand;

    @Field
    String leavingDate;

}
