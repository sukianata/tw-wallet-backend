/*
 * This file is generated by jOOQ.
 */
package com.thoughtworks.wallet.gen.tables.records;


import com.thoughtworks.wallet.gen.tables.TblVerifiers;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TblVerifiersRecord extends UpdatableRecordImpl<TblVerifiersRecord> implements Record4<Integer, String, String, Integer[]> {

    private static final long serialVersionUID = -894672010;

    /**
     * Setter for <code>public.tbl_verifiers.id</code>.
     */
    public TblVerifiersRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.tbl_verifiers.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.tbl_verifiers.name</code>.
     */
    public TblVerifiersRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.tbl_verifiers.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.tbl_verifiers.private_key</code>.
     */
    public TblVerifiersRecord setPrivateKey(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.tbl_verifiers.private_key</code>.
     */
    public String getPrivateKey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.tbl_verifiers.vc_types</code>.
     */
    public TblVerifiersRecord setVcTypes(Integer[] value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.tbl_verifiers.vc_types</code>.
     */
    public Integer[] getVcTypes() {
        return (Integer[]) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer[]> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, Integer[]> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TblVerifiers.TBL_VERIFIERS.ID;
    }

    @Override
    public Field<String> field2() {
        return TblVerifiers.TBL_VERIFIERS.NAME;
    }

    @Override
    public Field<String> field3() {
        return TblVerifiers.TBL_VERIFIERS.PRIVATE_KEY;
    }

    @Override
    public Field<Integer[]> field4() {
        return TblVerifiers.TBL_VERIFIERS.VC_TYPES;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getPrivateKey();
    }

    @Override
    public Integer[] component4() {
        return getVcTypes();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getPrivateKey();
    }

    @Override
    public Integer[] value4() {
        return getVcTypes();
    }

    @Override
    public TblVerifiersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TblVerifiersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TblVerifiersRecord value3(String value) {
        setPrivateKey(value);
        return this;
    }

    @Override
    public TblVerifiersRecord value4(Integer[] value) {
        setVcTypes(value);
        return this;
    }

    @Override
    public TblVerifiersRecord values(Integer value1, String value2, String value3, Integer[] value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TblVerifiersRecord
     */
    public TblVerifiersRecord() {
        super(TblVerifiers.TBL_VERIFIERS);
    }

    /**
     * Create a detached, initialised TblVerifiersRecord
     */
    public TblVerifiersRecord(Integer id, String name, String privateKey, Integer[] vcTypes) {
        super(TblVerifiers.TBL_VERIFIERS);

        set(0, id);
        set(1, name);
        set(2, privateKey);
        set(3, vcTypes);
    }
}