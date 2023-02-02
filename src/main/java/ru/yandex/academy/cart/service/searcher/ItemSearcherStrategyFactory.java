package ru.yandex.academy.cart.service.searcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.model.ItemTypeName;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ItemSearcherStrategyFactory {

	private final Map<ItemTypeName, ItemSearcherStrategy<?>> strategies;

	@Autowired
	public ItemSearcherStrategyFactory(Set<ItemSearcherStrategy<?>> strategySet) {
		strategies = new HashMap<>(3);
		strategySet.forEach(s -> strategies.put(s.getStrategyName(), s));
	}

	public ItemSearcherStrategy<?> getStrategy(ItemTypeName name) {
		return strategies.get(name);
	}
}
