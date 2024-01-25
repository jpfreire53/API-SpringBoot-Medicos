package med.voll.api.domain.medico.repository;

import med.voll.api.domain.medico.entity.Especialidade;
import med.voll.api.domain.medico.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select m from medicos m
            where
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where
                c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(@Param("especialidade") Especialidade especialidade, @Param("data") LocalDateTime data);

    @Query("""
            select m.ativo
            from medicos m
            where
            m.id = :id
            """)
    Boolean findAtivoById(@Param("id") Long id);
}
