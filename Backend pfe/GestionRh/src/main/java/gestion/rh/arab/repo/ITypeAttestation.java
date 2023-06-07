package gestion.rh.arab.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import gestion.rh.arab.entities.TypeAttestation;


@Repository
public interface ITypeAttestation extends JpaRepository<TypeAttestation, Integer> {
	

}
