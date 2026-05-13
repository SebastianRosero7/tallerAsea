package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.repositoriosJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.EstadoEntity;

public interface EstadoRepository extends JpaRepository <EstadoEntity,Integer>{

}
