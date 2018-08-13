package com.tcs.factory;

public abstract class AbstractFactory {
	public abstract DaoInterface getDao(String dao);
	public abstract ServiceInterface getService(String service);
}
