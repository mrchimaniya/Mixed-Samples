package com.divergentsl.repo;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.divergentsl.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, String> {
    Optional<Donor> findByPhone(String phone);
    List<Donor> findByBloodgroup(String bloodgroup);
	List<Donor> findByBloodgroupAndNearestbloodbank(String bloodGroup, String nearestBloodBank);
	Optional<Donor> findByPhoneAndPassword(String phone,String password);
	Optional<Donor> findByNameAndPhoneAndBloodgroup(String name,String phone,String bloodgroup);
	Integer deleteByPhone(String phone);
}
