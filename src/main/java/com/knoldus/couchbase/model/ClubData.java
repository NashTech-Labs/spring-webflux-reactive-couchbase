package com.knoldus.couchbase.model;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
public class ClubData {

    @Id
    String id;

    @Field
    String userId;

    @Field
    String clubCode;

    @Field
    String joiningDate;

    @Field
    String firstName;

    @Field
    String lastName;

}
