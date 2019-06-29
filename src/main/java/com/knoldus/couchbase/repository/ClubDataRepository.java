package com.knoldus.couchbase.repository;

import com.knoldus.couchbase.model.ClubData;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Flux;

public interface ClubDataRepository extends ReactiveCouchbaseRepository<ClubData, String> {

    String query = "select u.clubCode, u.joiningDate, u.userId, cmp.firstName, cmp.lastName," +
            " META(u).id AS _ID, META(u).cas AS _CAS from #{#n1ql.bucket} u" +
            " INNER JOIN #{#n1ql.bucket} cmp on KEYS u.userId" +
            " where u.clubCode = $1 and u.joiningDate = $2";

    @Query(query)
    Flux<ClubData> getClubData(String clubCode, String joiningDate);
}
