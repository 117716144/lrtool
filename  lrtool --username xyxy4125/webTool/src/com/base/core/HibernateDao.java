package com.base.core;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.base.core.util.Page;
import com.base.core.util.UbString;


/**
 * @author XIEYING
 *
 */
public class HibernateDao extends HibernateDaoSupport {
    public void refresh(Object entity) {
        getHibernateTemplate().refresh(entity);
    }

    public void delete(Object entity) {
        getHibernateTemplate().delete(entity);
    }

    public void save(Object entity) {
        getHibernateTemplate().saveOrUpdate(entity);

    }
    
    @SuppressWarnings("unchecked")
	public <UbaoType> UbaoType load(Class<UbaoType> entityClass, Serializable id) {
        return (UbaoType) getHibernateTemplate().load(entityClass, id);
    }

    public Long saveByObj(Object entity) {
        return (Long) getHibernateTemplate().save(entity);
    }

    public <UbaoType> UbaoType loadByLockflush(Class<UbaoType> entityClass, Serializable id, LockMode lockMode) {
    	UbaoType t=(UbaoType) getHibernateTemplate().load(entityClass, id, lockMode);
        if (t != null) {
            this.flush(); // 立即刷新，否则锁不会生效。
        }
        return t;
    }
    public <UbaoType> UbaoType getByLockflush(Class<UbaoType> entityClass, Serializable id, LockMode lockMode) {
    	UbaoType t=(UbaoType) getHibernateTemplate().get(entityClass, id, lockMode);
        if (t != null) {
            this.flush(); // 立即刷新，否则锁不会生效。
        }
        return t;
    }
   
 // 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
    public void flush() {
        getHibernateTemplate().flush();
    }

    public <UbaoType> List<UbaoType> findByNamedQuery(String queryName) {
        return findByNamedQuery(queryName, null);
    }

    public List findByNamedQuery(String queryName, Object param) {
        return findByNamedQuery(queryName, new Object[]{param});
    }

    public List findByNamedQuery(String queryName, Object[] params) {
        return getHibernateTemplate().findByNamedQuery(queryName, params);
    }

    private Object getUniqueResult(List result) {
        if (result != null && result.size() == 1) return result.get(0);
        return null;
        //throw new UbaoException("expect one record only,but two or more returned");
    }

    public Object findUniqueResultByNamedQuery(String queryName, Object param) {
        List result = findByNamedQuery(queryName, param);
        return getUniqueResult(result);
    }

    public Object findUniqueResultByNamedQuery(String queryName, Object[] params) {
        List result = findByNamedQuery(queryName, params);
        return getUniqueResult(result);
    }

    public List findByCriteria(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    public Object findUniqueResultByCriteria(DetachedCriteria criteria) {
        List result = getHibernateTemplate().findByCriteria(criteria);
        return getUniqueResult(result);
    }

    public List findPageByCriteria(final DetachedCriteria detachedCriteria, final Page page) {
        return (List) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                int totalCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
                page.setTotalAmount(totalCount);
                criteria.setProjection(null);
                criteria.setResultTransformer(Criteria.ROOT_ENTITY);
                return criteria.setFirstResult(page.getFirstIndexInPage()).setMaxResults(page.getPageSize()).list();
            }
        }, true);
    }

    public List findPageByCriteria(final DetachedCriteria detachedCriteria, final Page page, final Order order) {
        return (List) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                int totalCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
                page.setTotalAmount(totalCount);
                criteria.setProjection(null);
                criteria.addOrder(order);
                criteria.setResultTransformer(Criteria.ROOT_ENTITY);
                return criteria.setFirstResult(page.getFirstIndexInPage()).setMaxResults(page.getPageSize()).list();
            }
        }, true);
    }

    public List findPageByCriteria(final DetachedCriteria detachedCriteria, final Page page, final List<Order> orderList) {
        return (List) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                int totalCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
                page.setTotalAmount(totalCount);
                criteria.setProjection(null);
                for (int i = 0; i < orderList.size(); i++) {
                    Order order = orderList.get(i);
                    criteria.addOrder(order);
                }
                criteria.setResultTransformer(Criteria.ROOT_ENTITY);
                return criteria.setFirstResult(page.getFirstIndexInPage()).setMaxResults(page.getPageSize()).list();
            }
        }, true);
    }
    
	@SuppressWarnings("unchecked")
	public List getListByStanderdSQL(String sql,Class cls){
		Session session= this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		//取数
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List lBeans= new ArrayList();
		try {
			conn = session.connection();
			//执行sql
			logger.info(sql.toString());
//			ps = conn.prepareStatement(sql.toString());
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				T obj =(T)cls.newInstance();
//				ResultSetMetaData rsmd = rs.getMetaData();
//			    int numColumns = rsmd.getColumnCount();
//			    for (int i=1; i<numColumns+1; i++) {
//			        String columnName = rsmd.getColumnName(i);
//			        
//			    }
//			    Field[] fs =obj.getClass().getDeclaredFields();
//			}
//			if(rs.next()){
//				RowSetDynaClass rsdc = new RowSetDynaClass(rs);   
//				return rsdc.getRows();
//			}
			QueryRunner qRunner = new QueryRunner();   
			lBeans = (List) qRunner.query(conn,sql,new BeanListHandler(cls));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(null!=rs)rs.close();
				if(null!=ps)ps.close();	
				//if(null!=conn)conn.close();
			}catch (Exception e1) { e1.printStackTrace();
			}
		}
		return lBeans;
	}
	
	public int getCountByStanderdSQL(String sql){
		Session session= this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String countSql = "select count(*) from(" + sql
        + ") count_view";
		int resultCount = 0;
		try {
			conn = session.connection();
			//执行sql
			logger.info(countSql.toString());
			ps = conn.prepareStatement(countSql.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				resultCount =rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return resultCount;
	}


    /**
     * 获得查询的记录总数
     *
     * @param session
     * @param sql
     * @return 总数
     * @throws SQLException
     * @author :leoj
     */
    public int getRowCount(Session session, String sql) throws SQLException {
        Connection conn = session.connection();
        String countSql = "select count(*) from(" + sql
                + ") count_view";
        PreparedStatement countStat = conn.prepareStatement(countSql);
        int intRowCount = 0;
        ResultSet countRs = countStat.executeQuery();
        if (countRs.next())
            intRowCount = countRs.getInt(1);
        if (countRs != null)
            countRs.close();
        if (countStat != null)
            countStat.close();
        return intRowCount;
    }
    
    public List getListByStanderdSQL(final String sql) {
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                List ls = new ArrayList();
                Connection conn = session.connection();
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);
                int j = 0;
                while (rs.next()) {
                    int columnsLength = rs.getMetaData().getColumnCount();
                    if (columnsLength == 1)
                        ls.add(rs.getString(1));
                    else {
                        Object[] s = new Object[columnsLength];
                        for (int i = 0; i < columnsLength; i++) {
                            s[i] = rs.getString(i + 1);
                        }
                        ls.add(s);
                    }
                }
                if (rs != null)
                    rs.close();
                if (stat != null)
                    stat.close();
                return ls;
            }
        });
        return list;
    }

    /**
     * 执行查询记录
     *
     * @param session
     * @param sql
     * @param page
     * @return
     * @throws SQLException
     * @author :leoj
     */
    public ResultSet getResultSet(Session session, String sql, Page page) throws SQLException {
        Connection conn = session.connection();
        ResultSet rs = null;
        PreparedStatement stat = conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        int intRowCount = getRowCount(session, sql);
        if (!page.getIsAll()) {
            stat.setMaxRows(page.getPageStart() + page.getPageSize() + 1);
            rs = stat.executeQuery();
            if (rs.next()) {
                rs.last();
                page.setTotalAmount(intRowCount);
                // 将记录指针定位到待显示的第一条记录上
                rs.absolute(page.getPageStart());
            } else
                return null;
        } else {
            rs = stat.executeQuery();
            page.setTotalAmount(intRowCount);
        }
        return rs;
    }

    /**
     * 将Field的值 set到Map里。
     *
     * @param rs
     * @return
     * @throws SQLException
     * @author :leoj
     */
    public Map getFieldRelultSet(ResultSet rs) {
        String colValue, colType;
        Map record = new LinkedHashMap();
        ResultSetMetaData meta = null;
        try {
            meta = rs.getMetaData();
            for (int ii = 1, colNum = meta.getColumnCount(); ii <= colNum; ii++) {
                colValue = UbString.strNull(rs.getString(ii));
                colType = meta.getColumnTypeName(ii);
                if ("char".equals(colType.toLowerCase()) || "varchar".equals(colType.toLowerCase())) {
                    colValue = colValue.trim();
                } else if ("number".equals(colType.toLowerCase())) {
                    if (colValue.indexOf(".") == 0) {
                        colValue = "0" + colValue;
                    }
                }
                record.put(meta.getColumnName(ii), colValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    /**
     * 获得List 对像 页面获得：
     * 例如：List<CustomerQuestion> customerQuesList＝getListByStandardSQL（sql,page）;
     * 页面获得：
     * <s:iterator value="customerQuesList" status="ab">
     * <td class="b_bot"><s:property value="%{id}"/></td>
     * <td class="b_bot"><s:property value='%{is_solved.equals("Y")?"已解决":"解决中"}'/></td>
     * </s:iterator>
     *
     * @param sql
     * @param page
     * @return list
     * @author :leoj
     */

    public List getListByStandardSQL(final String sql, final Page page) {
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                List ls = new ArrayList();
                ResultSet rs = getResultSet(session, sql, page);
                if (rs == null)
                    return ls;
                int i = 0;
                int intPageSize = page.getPageSize();
                if (!page.getIsAll()) {
                    while (i < intPageSize && !rs.isAfterLast()) {
                        ls.add(getFieldRelultSet(rs));
                        rs.next();
                        i++;
                    }
                } else {
                    while (rs.next())
                        ls.add(getFieldRelultSet(rs));
                }
                if (rs != null)
                    rs.close();
                return ls;
            }
        }
        );
        return list;
    }

    /**
     * @param c
     * @return
     * @author :leoj
     */
    public Map getAllFields(Class c) {
        Class clz = c;
        Map<String, String> fieldsall = new HashMap();
        while (clz != null) {
            Field[] fields = clz.getDeclaredFields();
            for (Field flds : fields) {
                if (fieldsall.get(flds.getName()) == null) {
                    fieldsall.put(flds.getName(), flds.getName());
                }
            }
            clz = clz.getSuperclass();
        }
        return fieldsall;
    }

    /**
     * @param rs
     * @param clzMp
     * @param c
     * @return
     * @throws Exception
     */
    public Object getResultSetObj(ResultSet rs, Map<String, String> clzMp, Class c) throws Exception {
        return getResultSetObj(rs, clzMp, c, null);
    }

    /**
     * @param rs
     * @param clzMp
     * @param c
     * @param repleace_regex 将数据的字段有 repleace_regex 这个字符 替换成空。。如：repleace_regex="_"
     * @return
     * @throws Exception
     * @author :leoj
     */
    public Object getResultSetObj(ResultSet rs, Map<String, String> clzMp, Class c, String repleace_regex) throws Exception {
        ResultSetMetaData metaData = rs.getMetaData(); //取得结果集的元元素
        int colCount = metaData.getColumnCount();     //取得所有列的个数
        Object newInstance = c.newInstance();
        for (int i = 1; i <= colCount; i++) {
            try {
                Object value = rs.getObject(i);
                for (Iterator iter = clzMp.keySet().iterator(); iter.hasNext();) {
                    String name = (String) iter.next();
                    String columnName = metaData.getColumnName(i);
                    if (repleace_regex != null) {
                        if ("".equals(repleace_regex))
                            repleace_regex = "_";
                        columnName = columnName.replaceAll(repleace_regex, "");
                    }
                    if (name.equalsIgnoreCase(columnName))
                        BeanUtils.copyProperty(newInstance, name, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newInstance;
    }

    public List getListByStandardSQL(final String sql, final Class c) {
        Page page = new Page();
        page.setIsAll(true);
        return getListByStandardSQL(sql, page, c);
    }

    /**
     * @param sql
     * @param page
     * @param c    传入的是一个Mapping 对象，主要是将数据和字段对象化
     * @return
     * @author :leoj
     */
    public List getListByStandardSQL(final String sql, final Page page, final Class c) {
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                List ls = new ArrayList();
                ResultSet rs = getResultSet(session, sql, page);
                if (rs == null)
                    return ls;
                int i = 0;
                int intPageSize = page.getPageSize();
                Map<String, String> mp = getAllFields(c);
                if (!page.getIsAll()) {
                    while (i < intPageSize && !rs.isAfterLast()) {
                        try {
                            ls.add(getResultSetObj(rs, mp, c));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        rs.next();
                        i++;
                    }
                } else {
                    while (rs.next())
                        try {
                            ls.add(getResultSetObj(rs, mp, c));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
                if (rs != null)
                    rs.close();
                return ls;
            }
        }
        );
        return list;
    }

    /**
     * 通过标准的SQL分页查询数据
     *
     * @param sql String
     * @return List
     * @author :leoj
     */
    public List getListByStanderdSQL(final String sql, final Page page) {
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                List ls = new ArrayList();
                ResultSet rs = getResultSet(session, sql, page);
                if (rs == null)
                    return ls;
                int i = 0;
                int intPageSize = page.getPageSize();
                int columnsLength = rs.getMetaData().getColumnCount();
                if (!page.getIsAll()) {
                    while (i < intPageSize && !rs.isAfterLast()) {
                        Object[] s = new Object[columnsLength];
                        for (int colNum = 0; colNum < columnsLength; colNum++) {
                            s[colNum] = rs.getString(colNum + 1);
                        }
                        ls.add(s);
                        rs.next();
                        i++;
                    }
                } else {
                    while (rs.next()) {
                        Object[] s = new Object[columnsLength];
                        for (int colNum = 0; colNum < columnsLength; colNum++) {
                            s[colNum] = rs.getString(colNum + 1);
                        }
                        ls.add(s);
                    }
                }
                if (rs != null)
                    rs.close();
                return ls;
            }
        }
        );
        return list;
    }

 
    /**
     * 使用hql 语句进行查询
     *
     * @param hql
     * @param offset
     * @param length
     * @return List
     * @user:leoj
     */
    public List getListByHQL(final String hql, final int offset, final int length) {
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session.createQuery(hql);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                List list = query.list();
                return list;
            }
        });
        return list;
    }


    public int updateBySql(final String hql) {
        return updateBySql(hql, null);
    }

    public int updateBySql(final String hql, final Map param) {
        Integer num = (Integer) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        Query query = session.createQuery(hql);
                        if (null != param) {
                            String key = null;
                            for (Iterator iter = param.keySet().iterator(); iter.hasNext();) {
                                key = (String) iter.next();
                                query.setParameter(key, param.get(key));
                            }
                        }
                        return new Integer(query.executeUpdate());
                    }
                });
        return num.intValue();
    }


    public java.util.Date getSystemDateFromDatabase() {
        Date sysDate = (Date) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException, SQLException {
                        Connection conn = session.connection();
                        Statement stat = conn.createStatement();
                        String sql = "select sysdate from dual";
                        ResultSet rs = stat.executeQuery(sql);
                        if (rs.next()) {
                            java.sql.Timestamp timestamp = rs.getTimestamp(1);
                            java.util.Date dt = new java.util.Date(timestamp.getTime() + timestamp.getNanos());
                            return dt;
                        }
                        return new java.util.Date();
                    }

                });
        return sysDate;
    }

}
