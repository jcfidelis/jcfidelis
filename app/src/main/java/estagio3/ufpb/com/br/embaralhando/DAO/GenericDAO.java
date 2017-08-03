package estagio3.ufpb.com.br.embaralhando.DAO;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Jeferson on 03/08/2017.
 */

public class GenericDAO<T> extends BaseDaoImpl<T,Integer> {

    protected GenericDAO(Class<T> dataClass) throws SQLException {
        super(dataClass);
    }
    @Override
    public QueryBuilder<T, Integer> queryBuilder() {
        return super.queryBuilder();
    }

    @Override
    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }
}
