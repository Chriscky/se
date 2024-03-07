package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description key-value 类
 */
@Data
@AllArgsConstructor
public class Pair<K, V> {

	private final K key;
	private final V value;
}

