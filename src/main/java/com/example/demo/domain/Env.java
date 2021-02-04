package com.example.demo.domain;

import java.util.Map;


public class Env {
	private final Map<String, String> props;
	private final Map<String, String> env;

	public Env(Map<String, String> props, Map<String, String> env) {
		this.props = props;
		this.env = env;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public Map<String, String> getEnv() {
		return env;
	}

	@Override
	public String toString() {
		return "Env{" + "props=" + props + ", env=" + env + '}';
	}
}
