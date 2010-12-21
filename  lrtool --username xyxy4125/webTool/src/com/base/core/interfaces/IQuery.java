package com.base.core.interfaces;

public interface IQuery extends java.io.Serializable {
	@SuppressWarnings("unchecked")
	abstract Class get_type();

	abstract int get_firstIndex();

	abstract String get_sql();

	abstract int get_maxIndex();

	abstract String[] get_nameParameters();

	abstract Object[] get_values();

	@SuppressWarnings("unchecked")
	abstract void set_type(Class type);

	abstract void set_firstIndex(int firstIndex);

	abstract void set_sql(String sql);

	abstract void set_maxIndex(int maxIndex);

	abstract void set_nameParameters(String[] parameters);

	abstract void set_values(Object[] _values);

	abstract IQuery formatQueryForCount();

	abstract IQuery checkAndChangeQueryIndex(int defaultMaxOfPage, int defaultMaxOfRecordOnePage);

	abstract IQuery toQuery(int page, int recordonepage);
}
