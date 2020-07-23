package challenge;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	private final QuoteRepository repository;

	private final Random random;

	public QuoteServiceImpl(QuoteRepository repository, Random random) {
		this.repository = repository;
		this.random = random;
	}

	@Override
	public Quote getQuote() {
		final List<Integer> quotesIds = repository.buscaTodosIds();
		final int randomNumber = random.nextInt(quotesIds.size());
		final Integer randomId = quotesIds.get(randomNumber);
		return repository.findById(randomId)
				.orElseThrow(() -> new RuntimeException("Nao foi possivel recuperar uma frase (:"));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		final List<Quote> quotes = repository.findByActor(actor);
		final int randomNumber = random.nextInt(quotes.size());
		return quotes.get(randomNumber);
	}

}
