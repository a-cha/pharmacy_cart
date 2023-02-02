package ru.yandex.academy.cart.service.matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.model.ItemTypeName;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class MatcherStrategyFactory {

	private final Map<ItemTypeName, MatcherStrategy> strategies;

	@Autowired
	public MatcherStrategyFactory(Set<MatcherStrategy> strategySet) {
		strategies = new HashMap<>();
		strategySet.forEach(s -> strategies.put(s.getStrategyName(), s));
	}

	public MatcherStrategy getStrategy(ItemTypeName name) {
		return strategies.get(name);
	}
}
