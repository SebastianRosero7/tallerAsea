package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.ObservacionEntity;

public interface ObservacionRepository extends JpaRepository<ObservacionEntity,Integer>{

}
