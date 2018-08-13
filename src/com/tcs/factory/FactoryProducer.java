package com.tcs.factory;

public class FactoryProducer {
	
	public static AbstractFactory getFactory(String choice)
	{
		if(choice == "" || choice == null)
		{
			return null;
		}
		else if(choice.equalsIgnoreCase("DAO"))
		{
			return new DaoFactory();
		}
		else if(choice.equalsIgnoreCase("SERVICE"))
		{
			return new ServiceFactory();
		}
		return null;
	}
}
