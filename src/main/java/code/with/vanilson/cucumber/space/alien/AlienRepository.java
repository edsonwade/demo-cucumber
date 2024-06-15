package code.with.vanilson.cucumber.space.alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * AlienRepository
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-15
 */

public interface AlienRepository extends JpaRepository<Alien, Long> {

    @Query("""
                    SELECT COUNT (T.id)
                    FROM Alien T
                    WHERE
                    T.type = :type
            """)
    int countWithType(@Param("type") String type);


    @Query("""
                                SELECT A
                                FROM Alien A
                                WHERE
                                A.type = :type
            """
    )
    List<Alien> aliensOfType(@Param("type") String type);
}