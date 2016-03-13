
var DataAccessObject = function (SQLiteDAS, $cordovaSQLite, $q) {

    var lastQuery = null;

    function getDatabase() {
        return SQLiteDAS.getDatabase();
    }

    function rawQuery(query, whereValues, tx, success, error) {

        lastQuery = query;

        if (tx) {
            return tx.executeSql(query, whereValues, function (tx, res) {
                var isNativeSQLite = typeof res.rows.item !== 'undefined';

                if (res.rows && res.rows.length > 0) {
                    if (isNativeSQLite) {
                        var rows = [];

                        for (var i = 0; i < res.rows.length; i++) {
                            rows.push(res.rows.item(i));
                        }

                        success(tx, rows);
                    } else {
                        success(tx, res.rows);
                    }
                } else {
                    success(tx, []);
                }
            }, error);
        } else {
            var db = SQLiteDAS.getDatabase();
            var dfd = $q.defer();

            $cordovaSQLite.execute(db, query, whereValues)
                .then(function (res) {
                    var isNativeSQLite = typeof res.rows.item !== 'undefined';

                    if (res.rows && res.rows.length > 0) {
                        if (isNativeSQLite) {
                            var rows = [];

                            for (var i = 0; i < res.rows.length; i++) {
                                rows.push(res.rows.item(i));
                            }

                            dfd.resolve(rows);
                        } else {
                            dfd.resolve(res.rows);
                        }
                    } else {
                        dfd.resolve([]);
                    }
                }, function (error) {
                    dfd.reject(error);
                });

            ;

            return dfd.promise;
        }
    }

    function select(table, fields, where, tx, success, error) {

        if (fields !== '*') {
            fields = valuesToCSV(fields);
        }

        var query = "SELECT " + fields + " FROM " + table + " WHERE " + objectToWhereClause(where);
        var db = SQLiteDAS.getDatabase();
        var whereValues = dataToValueArray(where);

        lastQuery = query;

        if (tx) {
            return tx.executeSql(query, whereValues, function (tx, res) {
                var isNativeSQLite = typeof res.rows.item !== 'undefined';

                if (res.rows && res.rows.length > 0) {
                    if (isNativeSQLite) {
                        var rows = [];

                        for (var i = 0; i < res.rows.length; i++) {
                            rows.push(res.rows.item(i));
                        }

                        success(tx, rows);
                    } else {
                        success(tx, res.rows);
                    }
                } else {
                    success(tx, []);
                }
            }, error);
        } else {

            var dfd = $q.defer();

            $cordovaSQLite.execute(db, query, whereValues)
                .then(function (res) {
                    var isNativeSQLite = typeof res.rows.item !== 'undefined';

                    if (res.rows && res.rows.length > 0) {
                        if (isNativeSQLite) {
                            var rows = [];

                            for (var i = 0; i < res.rows.length; i++) {
                                rows.push(res.rows.item(i));
                            }

                            dfd.resolve(rows);
                        } else {
                            dfd.resolve(res.rows);
                        }
                    } else {
                        dfd.resolve([]);
                    }
                }, function (error) {
                    dfd.reject(error);
                });

            ;

            return dfd.promise;
        }

    }

    function insert(table, data, tx, success, error) {

        var columnNames = dataToColumnCSV(data);
        var values = dataToValueArray(data);

        var query = "INSERT INTO " + table + " (" + columnNames + ") VALUES (" + placeholders(values.length) + ")";

        lastQuery = query;

        if (tx) {
            return tx.executeSql(query, values, success, error);
        } else {
            var db = SQLiteDAS.getDatabase();
            var dfd = $q.defer();

            $cordovaSQLite.execute(db, query, values)
                .then(function (result) {
                    dfd.resolve(result);
                }, function (error) {
                    if (typeof error === 'object') {
                        error.lastQuery = lastQuery;
                    }
                    dfd.reject(error);
                })
                ;

            return dfd.promise;
        }

    }

    function update(table, data, where, tx, success, error) {

        var setClause = objectToSetClause(data);
        var whereClause = objectToWhereClause(where);
        var setValues = dataToValueArray(data);
        var whereValues = dataToValueArray(where);

        var allVariables = setValues.concat(whereValues);

        var query = "UPDATE " + table + " SET " + setClause + " WHERE " + whereClause;

        lastQuery = query;

        if (tx) {
            return tx.executeSql(query, allVariables, success, error);
        } else {
            var db = SQLiteDAS.getDatabase();
            var dfd = $q.defer();

            $cordovaSQLite.execute(db, query, allVariables)
                .then(function (result) {
                    dfd.resolve(result);
                }, function (error) {
                    if (typeof error === 'object') {
                        error.lastQuery = lastQuery;
                    }
                    dfd.reject(error);
                })
                ;

            return dfd.promise;
        }

    }

    function remove(table, where, tx, success, error) {

        var whereClause = objectToWhereClause(where);
        var whereValues = dataToValueArray(where);

        var query = "DELETE FROM " + table + " WHERE " + whereClause;

        lastQuery = query;

        if (tx) {
            return tx.executeSql(query, whereValues, success, error);
        } else {
            var db = SQLiteDAS.getDatabase();
            var dfd = $q.defer();

            $cordovaSQLite.execute(db, query, whereValues)
                .then(function (result) {
                    dfd.resolve(result);
                }, function (error) {
                    if (typeof error === 'object') {
                        error.lastQuery = lastQuery;
                    }
                    dfd.reject(error);
                })
                ;

            return dfd.promise;
        }

    }

    function getLastQuery() {
        return lastQuery;
    }

    //  <editor-fold desc="Common Query Methods" defaultstate="collapsed">

    function getLastUpdated(tableName, companyId, lastModifiedColumnName) {

        var dfd = $q.defer();

        if (!lastModifiedColumnName) {
            lastModifiedColumnName = 'last_modified';
        }

        var query = "SELECT " + lastModifiedColumnName + " FROM " + tableName + " WHERE company_id = " + companyId + " ORDER BY " + lastModifiedColumnName + " DESC LIMIT 1";
        rawQuery(query, [])
            .then(function (results) {
                if (results.length > 0) {
                    dfd.resolve(results[0][lastModifiedColumnName]);
                } else {
                    dfd.resolve(null);
                }
            }, function (error) {
                if (typeof error === 'object') {
                    error.lastQuery = lastQuery;
                }
                dfd.reject(error);
            })
            ;

        return dfd.promise;

    }

    function getAll(tableName, companyId) {

        var where = {
            company_id: companyId
        };

        var dfd = $q.defer();

        select(tableName, '*', where)
            .then(function (res) {
                dfd.resolve(res);
            }, function (error) {
                dfd.reject(error);
            })
            ;
        return dfd.promise;

    }

    function findById(tableName, id, tx, success, error) {

        var where = {
            id: id
        };

        select(tableName, '*', where, tx, function (tx, res) {
            if (res.rows && res.rows.length > 0) {
                if (res.rows.item) {
                    //  native sql
                    success(tx, res.rows.item(0));
                } else {
                    //  web sql
                    success(tx, res.rows[0]);
                }
            } else {
                success(tx, null);
            }
        }, error);

    }

    function find(tableName, webId, companyId, tx, success, error) {

        var where = {
            web_id: webId,
            company_id: companyId
        };

        if (tx) {
            return select(tableName, '*', where, tx, function (tx, res) {
                if (res.length > 0) {
                    success(tx, res[0]);
                } else {
                    success(tx, null);
                }
            }, error);
        } else {
            var dfd = $q.defer();

            select(tableName, '*', where)
                .then(function (res) {
                    if (res.length > 0) {
                        dfd.resolve(res[0]);
                    } else {
                        dfd.resolve(null);
                    }
                }, function (error) {
                    dfd.reject(error);
                })
                ;

            return dfd.promise;
        }

    }

    //  </editor-fold>

    //  <editor-fold desc="Private Utility Functions" defaultstate="collapsed">

    function objectToSetClause(setObj) {
        var setClauseList = [];

        for (var column in setObj) {
            setClauseList.push(column + " = ?");
        }

        return setClauseList.join(', ');
    }

    function objectToWhereClause(whereObj) {

        var whereObjs = [];

        for (var column in whereObj) {
            whereObjs.push(column + " = ?");
        }

        return whereObjs.join(' AND ');

    }

    function dataToColumnCSV(data) {
        var columnNames = [];

        for (var column in data) {
            columnNames.push(column);
        }

        return columnNames.join(',');
    }

    function valuesToCSV(values) {
        var values = [];

        for (var column in values) {
            values.push(values[column]);
        }

        return values.join(',');
    }

    function dataToValueArray(data) {
        var values = [];

        for (var column in data) {
            values.push(data[column]);
        }

        return values;
    }

    function placeholders(count) {
        var placeholders = [];

        for (var i = 0; i < count; i++) {
            placeholders.push("?");
        }

        return placeholders.join(',');
    }

    //  </editor-fold>

    return {
        getDatabase: getDatabase,
        rawQuery: rawQuery,
        select: select,
        insert: insert,
        update: update,
        remove: remove,
        getLastQuery: getLastQuery,
        commonQueries: {
            find: find,
            findById: findById,
            getAll: getAll,
            getLastUpdated: getLastUpdated
        }
    };

};
