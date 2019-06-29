package com.knoldus.couchbase.controller;

import com.knoldus.couchbase.model.ClubData;
import com.knoldus.couchbase.model.ClubMemberProfile;
import com.knoldus.couchbase.model.User;
import com.knoldus.couchbase.repository.ClubDataRepository;
import com.knoldus.couchbase.repository.ClubMemberProfileRepository;
import com.knoldus.couchbase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClubController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClubMemberProfileRepository clubMemberProfileRepository;

    @Autowired
    private ClubDataRepository clubDataRepository;

    @PostMapping("/club/users")
    public Mono<User> addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/club/members")
    public Mono<ClubMemberProfile> addClubMember(@RequestBody ClubMemberProfile clubMemberProfile) {
        return clubMemberProfileRepository.save(clubMemberProfile);
    }

    @GetMapping("/club/users/{name}/{city}")
    public Mono<User> getUser(@PathVariable String name, @PathVariable String city) {
        return userRepository.findByFirstNameAndCity(name, city);
    }

    @GetMapping("/club/members/{code}/{date}")
    public Flux<ClubMemberProfile> getClubMembers(@PathVariable String code, @PathVariable String date) {
        return clubMemberProfileRepository.getClubMembers(code, date);
    }

    @GetMapping("/club/codes/{location}/{brand}")
    public Flux<String> getClubCodes(@PathVariable String location, @PathVariable String brand) {
        return clubMemberProfileRepository.getAllClubCodes(location, brand);
    }

    @GetMapping("/club/data/{code}/{date}")
    public Flux<ClubData> getClubData(@PathVariable String code, @PathVariable String date) {
        return clubDataRepository.getClubData(code, date);
    }

}
