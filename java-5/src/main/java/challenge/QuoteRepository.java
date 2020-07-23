package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    @Query(
            "SELECT " +
                    "quote.id " +
            "FROM " +
                    "Quote quote"
    )
    List<Integer> buscaTodosIds();


    List<Quote> findByActor(String actor);

}
