package com.hajer.livres_proj.repos;

import com.hajer.livres_proj.entities.Ecrivain;
import com.hajer.livres_proj.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface LivreRepository extends JpaRepository<Livre, Long> {

    // --- TP02 : Recherche par titre ---
    List<Livre> findByTitreLivre(String titre);

    List<Livre> findByTitreLivreContains(String titre);

    // --- TP02 : @Query JPQL multi-critères ---
    @Query("select l from Livre l where l.titreLivre like %:titre and l.nombrePages > :pages")
    List<Livre> findByTitrePages(@Param("titre") String titre,
                                 @Param("pages") Long pages);

    // --- TP02 : @Query avec entité en paramètre ---
    @Query("select l from Livre l where l.ecrivain = ?1")
    List<Livre> findByEcrivain(Ecrivain ecrivain);

    // --- TP02 : Recherche par id de l'écrivain ---
    List<Livre> findByEcrivainIdEcrivain(Long id);

    // --- TP02 : Tri par titre ASC ---
    List<Livre> findByOrderByTitreLivreAsc();

    // --- TP02 : Tri par titre ASC et nombrePages DESC ---
    @Query("select l from Livre l order by l.titreLivre ASC, l.nombrePages DESC")
    List<Livre> trierLivresTitresPages();
}
