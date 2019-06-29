package com.knoldus.couchbase.repository;

import com.knoldus.couchbase.model.ClubMemberProfile;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClubMemberProfileRepository extends ReactiveCouchbaseRepository<ClubMemberProfile, String> {

    @Query("select META().id AS _ID, META().cas AS _CAS, * from #{#n1ql.bucket} where clubCode = $1 and joiningDate = $2")
    Flux<ClubMemberProfile> getClubMembers(String clubCode, String joiningDate);

    @Query("select clubCode from #{#n1ql.bucket} where location = $1 and brand = $2")
    Flux<String> getAllClubCodes(String location, String brand);

}
