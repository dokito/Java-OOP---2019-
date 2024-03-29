package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardRepositoryImpl implements CardRepository {

    private Map<String, Card> cards;

    public CardRepositoryImpl() {
        this.cards = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.cards.values().size();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards.values().stream().collect(Collectors.toList()));
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        if (cards.containsKey(card.getName())){
            throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
        }

        cards.put(card.getName(), card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }

        Card removedCard = this.cards.remove(card.getName());
        boolean isRemoved = true;

        if (removedCard == null) {
            isRemoved = false;
        }

        return isRemoved;
    }

    @Override
    public Card find(String name) {
        Card card = this.cards.get(name);
        return card;
    }
}
