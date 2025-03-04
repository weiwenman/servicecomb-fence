/*
 * This file is generated by jOOQ.
 */
package org.apache.servicecomb.fence.jooqdemo.db.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.servicecomb.fence.jooqdemo.db.Indexes;
import org.apache.servicecomb.fence.jooqdemo.db.Keys;
import org.apache.servicecomb.fence.jooqdemo.db.Public;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.StoreRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Store extends TableImpl<StoreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.store</code>
     */
    public static final Store STORE = new Store();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreRecord> getRecordType() {
        return StoreRecord.class;
    }

    /**
     * The column <code>public.store.store_id</code>.
     */
    public final TableField<StoreRecord, Long> STORE_ID = createField(DSL.name("store_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.store.manager_staff_id</code>.
     */
    public final TableField<StoreRecord, Long> MANAGER_STAFF_ID = createField(DSL.name("manager_staff_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.store.address_id</code>.
     */
    public final TableField<StoreRecord, Long> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.store.last_update</code>.
     */
    public final TableField<StoreRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "");

    private Store(Name alias, Table<StoreRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Store(Name alias, Table<StoreRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.store</code> table reference
     */
    public Store(String alias) {
        this(DSL.name(alias), STORE);
    }

    /**
     * Create an aliased <code>public.store</code> table reference
     */
    public Store(Name alias) {
        this(alias, STORE);
    }

    /**
     * Create a <code>public.store</code> table reference
     */
    public Store() {
        this(DSL.name("store"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_UNQ_MANAGER_STAFF_ID);
    }

    @Override
    public Identity<StoreRecord, Long> getIdentity() {
        return (Identity<StoreRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<StoreRecord> getPrimaryKey() {
        return Keys.STORE_PKEY;
    }

    @Override
    public Store as(String alias) {
        return new Store(DSL.name(alias), this);
    }

    @Override
    public Store as(Name alias) {
        return new Store(alias, this);
    }

    @Override
    public Store as(Table<?> alias) {
        return new Store(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(String name) {
        return new Store(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(Name name) {
        return new Store(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Store rename(Table<?> name) {
        return new Store(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Store where(Condition condition) {
        return new Store(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Store where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Store where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Store where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Store where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Store where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Store where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Store where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Store whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Store whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
